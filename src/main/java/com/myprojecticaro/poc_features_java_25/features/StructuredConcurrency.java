package com.myprojecticaro.poc_features_java_25.features;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.List;
import java.util.ArrayList;

public class StructuredConcurrency {
    public static void runExample() throws InterruptedException {

        try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var futures = new ArrayList<java.util.concurrent.Future<String>>();


            futures.add(scope.fork(() -> {
                Thread.sleep(200);
                return "result-1";
            }));


            futures.add(scope.fork(() -> {
                Thread.sleep(100);
                return "result-2";
            }));


            scope.join(); 
            scope.throwIfFailed();


            for (var f : futures) {
                try {
                    System.out.println(" -> " + f.get());
                } catch (ExecutionException e) {
                    System.out.println(" -> task failed: " + e.getMessage());
                }
            }
        }
    }
}
