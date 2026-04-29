package com.myprojecticaro.poc_features_java_25.features.scopedvalues;

import java.lang.ScopedValue;

public class ScopedValuesBasicExample {

    private static final ScopedValue<RequestContext> CONTEXT =
            ScopedValue.newInstance();

    public void run() {
        System.out.println("Running basic scoped value example");

        // where associa um valor imutavel (CONTEXT) a um scoped value
        ScopedValue.where(
                CONTEXT,
                new RequestContext("req-123", "icaro")
        ).run(this::serviceLayer);
    }

    // simula a camada de servico
    private void serviceLayer() {
        repositoryLayer();
    }

    private void repositoryLayer() {
        RequestContext context = CONTEXT.get();
        System.out.println("Context available in repository: " + context);
    }
}

