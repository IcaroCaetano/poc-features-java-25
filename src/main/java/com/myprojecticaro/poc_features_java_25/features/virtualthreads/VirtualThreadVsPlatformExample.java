package com.myprojecticaro.poc_features_java_25.features.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreadVsPlatformExample {

    public void run() throws InterruptedException {

        long startPlatform = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            for (int i = 0; i < 1000; i++) {
                executor.submit(this::blockingTask);
            }
        }

        long endPlatform = System.currentTimeMillis();

        long startVirtual = System.currentTimeMillis();

        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1000; i++) {
                executor.submit(this::blockingTask);
            }
        }

        long endVirtual = System.currentTimeMillis();

        System.out.println("Platform Threads: " + (endPlatform - startPlatform));
        System.out.println("Virtual Threads: " + (endVirtual - startVirtual));
    }

    private void blockingTask() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {}
    }
}