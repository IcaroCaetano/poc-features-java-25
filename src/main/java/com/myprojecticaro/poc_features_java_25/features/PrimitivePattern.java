package com.myprojecticaro.poc_features_java_25.features;

/**
 * Demonstrates the use of primitive patterns in switch expressions,
 * a feature introduced as a preview in Java 25.
 * <p>
 * Primitive patterns allow developers to directly match primitive types
 * (such as {@code int}, {@code double}, {@code short}) in a {@code switch},
 * simplifying code and making it more expressive.
 * </p>
 *
 * <p>
 * This example iterates over an array of heterogeneous objects and uses
 * a {@code switch} expression with primitive patterns to determine
 * their type and produce a formatted result.
 * </p>
 *
 * <pre>
 * Example output:
 *  -> int: 10
 *  -> double: 3.14
 *  -> string: hello
 *  -> short: 7
 * </pre>
 */
public class PrimitivePattern {

    /**
     * Runs a demonstration of primitive pattern matching in a {@code switch} expression.
     * <p>
     * The method creates an array of objects containing different types
     * (int, double, String, short) and applies a {@code switch} expression
     * to identify and format each element accordingly.
     * </p>
     */
    public static void runExample() {

        Object[] inputs = { 10, 3.14, "hello", (short) 7 };

        for (Object o : inputs) {
            String result = switch (o) {
                case int i -> "int: " + i;
                case double d -> "double: " + d;
                case short s -> "short: " + s;
                case String s -> "string: " + s;
                default -> "unknown: " + o;
            };

            System.out.println(" -> " + result);
        }
    }
}
