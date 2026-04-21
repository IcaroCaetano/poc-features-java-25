package com.myprojecticaro.poc_features_java_25.features.virtualthreads;

public class VirtualThreadBasicExample {

    public void run() {
        Thread.startVirtualThread(() -> {
            System.out.println("Running in virtual thread: " + Thread.currentThread());
        });
    }
}