package com.myprojecticaro.poc_features_java_25.features;

import java.util.concurrent.Executors;

/**
 * Demonstrates the use of Scoped Values, a feature in Java 25 that provides
 * a lightweight and immutable mechanism for sharing data within and across threads.
 * <p>
 * Scoped Values act as a safer and more efficient alternative to
 * {@link ThreadLocal}, allowing developers to bind a value to a scope
 * and guarantee immutability and proper cleanup.
 * </p>
 *
 * <p>
 * This example binds a scoped value (representing a user context) and
 * accesses it within a separate thread, demonstrating that the value
 * is available within the defined scope.
 * </p>
 *
 * <h2>Also Demonstrates:</h2>
 * <ul>
 *   <li>Flexible constructor bodies (JEP 513) with validation before
 *   invoking {@code super(...)}.</li>
 * </ul>
 */
public class ScopedValues {

    /**
     * A scoped value representing a user context (e.g., user ID).
     */
    public static final ScopedValue<String> CONTEXT = java.lang.ScopedValue.newInstance();

    /**
     * Runs a demonstration of Scoped Values.
     * <p>
     * A scoped value is bound to the current scope with the value {@code "user-123"}.
     * A task is then submitted to a single-thread executor, which reads the value
     * within the same scope.
     * </p>
     *
     * <pre>
     * Example output:
     *  scoped value inside thread: user-123
     * </pre>
     */
    public static void runExample() {
        var runnable = (Runnable) () ->
            System.out.println(" scoped value inside thread: " + CONTEXT.get());

        try {
            java.lang.ScopedValue.where(CONTEXT, "user-123").run(() -> {
                var es = Executors.newSingleThreadExecutor();
                try {
                    es.submit(runnable).get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    es.shutdownNow();
                }
            });
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    /**
     * Simple parent class used in the flexible constructor example.
     */
    static class ParentForFlexible {
        private final int value;

        ParentForFlexible(int value) {
            this.value = value;
        }

        public int getValue() { return value; }

        /**
         * Demonstrates flexible constructor bodies (JEP 513).
         * <p>
         * Allows performing validation and logic before calling {@code super(...)}.
         * </p>
         */
        public static class FlexibleConstructorExample extends ParentForFlexible {
            private final int value;

            public FlexibleConstructorExample(int value) {
                if (value < 0) {
                    throw new IllegalArgumentException("value must be >= 0");
                }
                this.value = value * 1; // additional logic possible
                super(value); // call to superclass constructor after pre-validation
            }

            @Override
            public int getValue() { return value; }
        }
    }

    /**
     * Another demonstration of flexible constructor bodies referencing
     * {@link com.myprojecticaro.poc_features_java_25.features.ParentForFlexible}.
     */
    public static class FlexibleConstructorExample
            extends com.myprojecticaro.poc_features_java_25.features.ParentForFlexible {

        private final int value;

        /**
         * Constructs a new instance with validation and transformation logic
         * executed before calling the parent constructor.
         *
         * @param value the input value (must be {@code >= 0})
         * @throws IllegalArgumentException if {@code value < 0}
         */
        public FlexibleConstructorExample(int value) {
            // validation and logic *before* super(...) — JEP 513 (flexible constructor bodies)
            if (value < 0) {
                throw new IllegalArgumentException("value must be >= 0");
            }
            this.value = value * 1; // additional logic possible
            super(value); // call to superclass constructor after pre-validation
        }

        @Override
        public int getValue() { return value; }
    }
}
