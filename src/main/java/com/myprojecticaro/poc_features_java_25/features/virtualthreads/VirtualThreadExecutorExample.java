package com.myprojecticaro.poc_features_java_25.features.virtualthreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class VirtualThreadExecutorExample {

    public void run() {
        System.out.println("Start Virtual Thread Executor");
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            IntStream.range(0, 10_000).forEach(i ->
                executor.submit(() -> {
                    System.out.println("Task " + i + " -> " + Thread.currentThread());
                })
            );
        }
        System.out.println("End Virtual Thread Executor");
    }
}