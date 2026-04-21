package com.myprojecticaro.poc_features_java_25.features.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingExample {

    public void run() {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < 5; i++) {
                int taskId = i;

                executor.submit(() -> {
                    System.out.println("Start task " + taskId);

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ignored) {}

                    System.out.println("End task " + taskId);
                });
            }
        }
    }
}