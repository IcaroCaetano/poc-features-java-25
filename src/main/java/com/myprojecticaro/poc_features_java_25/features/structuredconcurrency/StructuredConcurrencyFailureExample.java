package com.myprojecticaro.poc_features_java_25.features.structuredconcurrency;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyFailureExample {

    public void run() {

        try (var scope = StructuredTaskScope.open()) {

            var user = scope.fork(this::fetchUser);
            var order = scope.fork(this::fetchOrderWithError);

            scope.join();

            // Aqui o erro vai aparecer ao tentar acessar o resultado
            System.out.println("User: " + user.get());
            System.out.println("Order: " + order.get());

        } catch (Exception e) {
            System.out.println("Error handled: " + e.getMessage());
        }
    }

    private String fetchUser() throws InterruptedException {
        Thread.sleep(1000);
        return "User fetched";
    }

    private String fetchOrderWithError() {
        throw new RuntimeException("Order service failed!");
    }
}