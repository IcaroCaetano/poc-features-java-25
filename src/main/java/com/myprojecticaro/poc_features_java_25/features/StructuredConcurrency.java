package com.myprojecticaro.poc_features_java_25.features;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;
import java.util.ArrayList;

/**
 * Demonstrates Structured Concurrency, a feature preview in Java 25.
 * <p>
 * Structured Concurrency simplifies multithreaded programming by treating
 * groups of tasks running in different threads as a single unit of work.
 * This helps improve reliability, readability, and error handling.
 * </p>
 *
 * <p>
 * In this example, two tasks are executed in parallel using
 * {@link StructuredTaskScope.ShutdownOnFailure}. If any task fails,
 * all other tasks are automatically cancelled, ensuring a consistent
 * lifecycle for concurrent operations.
 * </p>
 *
 * <pre>
 * Example output:
 *  -> result-1
 *  -> result-2
 * </pre>
 */
public class StructuredConcurrency {

    /**
     * Runs a demonstration of Structured Concurrency.
     *
     * <p>
     * The method creates a {@link StructuredTaskScope.ShutdownOnFailure}
     * that forks two tasks:
     * <ul>
     *   <li>A task that sleeps for 200ms and returns {@code "result-1"}</li>
     *   <li>A task that sleeps for 100ms and returns {@code "result-2"}</li>
     * </ul>
     * The scope waits for all tasks to complete. If a failure occurs,
     * it cancels the remaining tasks and propagates the exception.
     * </p>
     *
     * @throws InterruptedException if the current thread is interrupted
     *                              while waiting for tasks to complete
     */
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

            // Wait for all tasks to finish
            scope.join();
            // Propagate exceptions if any task failed
            scope.throwIfFailed();

            // Print results
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
