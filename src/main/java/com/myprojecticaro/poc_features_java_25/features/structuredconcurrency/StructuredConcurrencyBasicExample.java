package com.myprojecticaro.poc_features_java_25.features.structuredconcurrency;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyBasicExample {

    public void run() throws Exception {

        System.out.println("StructuredConcurrencyBasicExample Start");
        long start = System.currentTimeMillis();

        // Controle de ciclo de vida com concorrência = estruturada e previsível
            try (var scope = StructuredTaskScope.open()) {

                // fork - Cria e inicia uma tarefa concorrente dentro do escopo
                var user = scope.fork(this::fetchUser);
                var order = scope.fork(this::fetchOrder);

                //join - funciona como um ponto de sincronização
                scope.join();

                String userResult = user.get();
                String orderResult = order.get();

                System.out.println("User: " + userResult);
                System.out.println("Order: " + orderResult);
            }

        long end = System.currentTimeMillis();
        System.out.println("StructuredConcurrencyBasicExample End " + + (end - start));
    }

    private String fetchUser() throws InterruptedException {
        Thread.sleep(1000);
        return "User fetched";
    }

    private String fetchOrder() throws InterruptedException {
        Thread.sleep(1200);
        return "Order fetched";
    }
}