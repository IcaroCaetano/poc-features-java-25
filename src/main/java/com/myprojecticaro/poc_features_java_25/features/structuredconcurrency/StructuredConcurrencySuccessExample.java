package com.myprojecticaro.poc_features_java_25.features.structuredconcurrency;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencySuccessExample {

    public void run() throws Exception {

        try (var scope = StructuredTaskScope.open()) {

            var fast = scope.fork(this::fastTask);
            var slow = scope.fork(this::slowTask);

            scope.join();

            String result;

            if (fast.state() == StructuredTaskScope.Subtask.State.SUCCESS) {
                result = fast.get();
            } else {
                result = slow.get();
            }

            System.out.println("First result: " + result);
        }
    }

    private String fastTask() throws InterruptedException {
        Thread.sleep(500);
        return "Fast result";
    }

    private String slowTask() throws InterruptedException {
        Thread.sleep(2000);
        return "Slow result";
    }
}