package com.nhnent.edu.spring_boot;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

// TODO : #1 Custom Actuator
@Component
@Endpoint(id = "counter")
public class CounterActuator {
    private final AtomicLong counter = new AtomicLong();


    // HTTP GET Method
    @ReadOperation
    public Long incrementAndGet() {
        return counter.incrementAndGet();
    }

    // HTTP POST Method
    // @WriteOperation

    // HTTP DELETE Method
    @DeleteOperation
    public void reset() {
        counter.set(0);
    }

}
