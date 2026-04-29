package com.myprojecticaro.poc_features_java_25.features.scopedvalues;

import java.lang.ScopedValue;

public class ScopedValuesBasicExample {

    private static final ScopedValue<RequestContext> CONTEXT = ScopedValue.newInstance();

    public void run() {
        System.out.println("Running basic scoped value example");

        // where associa um valor imutavel (CONTEXT) a um scoped value
        // representa um idenficador do escopo, ou seja um objeto do tipo ScopedValue<RequestContext>
        ScopedValue.where(
                CONTEXT,
                // Aqui estou setando um valor um imutavel
                new RequestContext("req-123", "icaro")
            // Aqui acontece a execucao real
            // Esse sera o codigo que executado dentro do escopo
        ).run(this::serviceLayer);
    }

    // simula a camada de servico
    private void serviceLayer() {
        repositoryLayer();
    }

    // Simula a camada repository
    private void repositoryLayer() {
        // E passado o valor do contexto
        RequestContext context = CONTEXT.get();
        System.out.println("Context available in repository: " + context);
    }
}

