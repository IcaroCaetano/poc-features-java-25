package com.myprojecticaro.poc_features_java_25.features;

import java.util.concurrent.Executors;

public class ScopedValues {
    // ScopedValue API (estilo JDK 21+) — cria um valor imutável ligado a um escopo
    public static final ScopedValue<String> CONTEXT = java.lang.ScopedValue.newInstance();


    public static void runExample() {
        var runnable = (Runnable) () -> {
            // dentro do scope o valor está disponível
            System.out.println(" scoped value inside thread: " + CONTEXT.get());
        };


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

    static class ParentForFlexible {
    private final int value;
    ParentForFlexible(int value) {
    this.value = value;
    }
    public int getValue() { return value; }

        public static class FlexibleConstructorExample extends ParentForFlexible {
        private final int value;


        public FlexibleConstructorExample(int value) {
        // validações e lógica *antes* do super(...) — JEP 513 (flexible constructor bodies)
        if (value < 0) {
        throw new IllegalArgumentException("value must be >= 0");
        }
        this.value = value * 1; // lógica adicional possível
        super(value); // chamada ao construtor da superclasse após pré-validação
        }


        public int getValue() { return value; }
        }
    }

    public static class FlexibleConstructorExample extends com.myprojecticaro.poc_features_java_25.features.ParentForFlexible {
    private final int value;


    public FlexibleConstructorExample(int value) {
    // validações e lógica *antes* do super(...) — JEP 513 (flexible constructor bodies)
    if (value < 0) {
    throw new IllegalArgumentException("value must be >= 0");
    }
    this.value = value * 1; // lógica adicional possível
    super(value); // chamada ao construtor da superclasse após pré-validação
    }


    public int getValue() { return value; }
    }
}
