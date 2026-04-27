package com.myprojecticaro.poc_features_java_25.features.scopedvalues;

import java.lang.ScopedValue;

public class ScopedValuesVsThreadLocalExample {

    private static final ThreadLocal<String> THREAD_LOCAL =
            new ThreadLocal<>();

    private static final ScopedValue<String> SCOPED =
            ScopedValue.newInstance();

    public void run() {
        System.out.println("Comparing ThreadLocal vs ScopedValue");

        THREAD_LOCAL.set("thread-local-value");
        legacyMethod();
        THREAD_LOCAL.remove();

        ScopedValue.where(SCOPED, "scoped-value").run(this::modernMethod);
    }

    private void legacyMethod() {
        System.out.println("ThreadLocal value = " + THREAD_LOCAL.get());
    }

    private void modernMethod() {
        System.out.println("ScopedValue value = " + SCOPED.get());
    }
}

