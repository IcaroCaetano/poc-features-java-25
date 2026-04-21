package com.myprojecticaro.poc_features_java_25.features.virtualthreads;

public class VirtualThreadDemo {

    public static void main(String[] args) throws Exception {

        new VirtualThreadBasicExample().run();

        new VirtualThreadExecutorExample().run();

        new BlockingExample().run();

        new VirtualThreadVsPlatformExample().run();
    }
}