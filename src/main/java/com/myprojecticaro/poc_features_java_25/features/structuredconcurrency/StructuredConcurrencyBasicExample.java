package com.myprojecticaro.poc_features_java_25.features.structuredconcurrency;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyBasicExample {

    public void run() throws Exception {

        try (var scope = StructuredTaskScope.open()) {

            var user = scope.fork(this::fetchUser);
            var order = scope.fork(this::fetchOrder);

            scope.join();

            String userResult = user.get();
            String orderResult = order.get();

            System.out.println("User: " + userResult);
            System.out.println("Order: " + orderResult);
        }
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