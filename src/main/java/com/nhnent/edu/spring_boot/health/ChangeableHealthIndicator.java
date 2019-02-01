package com.nhnent.edu.spring_boot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public interface ChangeableHealthIndicator extends HealthIndicator {
    void changeHealth(Health health);

}
