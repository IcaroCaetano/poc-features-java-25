package com.myprojecticaro.poc_features_java_25.features.core.clock;

import java.time.Clock;
import java.time.Instant;

public class TimeProvider {

    private final Clock clock;

    public TimeProvider(Clock clock) {
        this.clock = clock;
    }

    public Instant now() {
        return Instant.now(clock);
    }
}