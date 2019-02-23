package com.nhnent.edu.spring_boot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicReference;

// TODO : #2 custom HealthIndicator implementation.
@Component
public class ManualHealthIndicator implements ChangeableHealthIndicator {
    private final AtomicReference<Health> healthRef = new AtomicReference<>(Health.up().build());


    @Override
    public Health health() {
        return healthRef.get();
    }

    @Override
    public void changeHealth(Health health) {
        healthRef.set(health);
    }

}
