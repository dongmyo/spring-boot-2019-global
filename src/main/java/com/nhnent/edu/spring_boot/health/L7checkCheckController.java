package com.nhnent.edu.spring_boot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// TODO : #3 the controller to control the custom health indicator.
@RestController
@RequestMapping("${l7check.uri:/l7check}")
public class L7checkCheckController {
    private static final Set<String> LOCAL_IPS = Collections.unmodifiableSet(
            new HashSet<>(Arrays.asList("0:0:0:0:0:0:0:1", "127.0.0.1")));


    private final ChangeableHealthIndicator indicator;


    public L7checkCheckController(ChangeableHealthIndicator indicator) {
        this.indicator = indicator;
    }

    @GetMapping
    public ResponseEntity health() {
        Health health = indicator.health();
        boolean isUp = health.getStatus().equals(Status.UP);
        return ResponseEntity
                .status(isUp ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE)
                .build();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void down(HttpServletRequest request) {
        checkLocalIp(request.getRemoteAddr());
        indicator.changeHealth(Health.down().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void up(HttpServletRequest request) {
        checkLocalIp(request.getRemoteAddr());
        indicator.changeHealth(Health.up().build());
    }

    private void checkLocalIp(String ip) {
        if (!LOCAL_IPS.contains(ip)) {
            throw new ForbiddenException(ip);
        }
    }


    @ResponseStatus(HttpStatus.FORBIDDEN)
    static class ForbiddenException extends RuntimeException {
        ForbiddenException(String ip) {
            super(ip);
        }
    }

}
