package com.myprojecticaro.poc_features_java_25.features.structuredconcurrency;

public class StructuredConcurrencyDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("=== BASIC ===");
        new StructuredConcurrencyBasicExample().run();

        System.out.println("\n=== FAILURE ===");
        new StructuredConcurrencyFailureExample().run();

        System.out.println("\n=== SUCCESS ===");
        new StructuredConcurrencySuccessExample().run();
    }
}