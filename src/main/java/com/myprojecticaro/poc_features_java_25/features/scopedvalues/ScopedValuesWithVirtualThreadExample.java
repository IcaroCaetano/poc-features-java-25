package com.myprojecticaro.poc_features_java_25.features.scopedvalues;

import java.lang.ScopedValue;
import java.util.concurrent.Executors;

public class ScopedValuesWithVirtualThreadExample {

    private static final ScopedValue<RequestContext> CONTEXT = ScopedValue.newInstance();

    public void run() throws Exception {
        System.out.println("Running scoped values with virtual threads");

        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {

            ScopedValue.where(
                    CONTEXT,
                    new RequestContext("req-vt-999", "virtual-user")
            ).run(() -> {
                executor.submit(this::asyncOperation).join();
            });
        }
    }

    private void asyncOperation() {
        System.out.println("Virtual Thread context: " + CONTEXT.get());
    }
}

