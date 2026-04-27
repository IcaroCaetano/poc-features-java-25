package com.myprojecticaro.poc_features_java_25.features.scopedvalues;

public class ScopedValuesDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("=== BASIC ===");
        new ScopedValuesBasicExample().run();

        System.out.println("\n=== VIRTUAL THREAD ===");
        new ScopedValuesWithVirtualThreadExample().run();

        System.out.println("\n=== THREADLOCAL VS SCOPED ===");
        new ScopedValuesVsThreadLocalExample().run();
    }
}
