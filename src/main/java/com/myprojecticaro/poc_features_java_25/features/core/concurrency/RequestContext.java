package com.myprojecticaro.poc_features_java_25.features.core.concurrency;

import java.lang.ScopedValue;

public class RequestContext {

    public static final ScopedValue<String> USER = ScopedValue.newInstance();

    public static void runWithUser(String user, Runnable runnable) {
        ScopedValue.where(USER, user).run(runnable);
    }
}