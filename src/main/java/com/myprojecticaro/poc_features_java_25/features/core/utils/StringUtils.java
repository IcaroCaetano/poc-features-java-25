package com.myprojecticaro.poc_features_java_25.features.core.utils;

public class StringUtils {

    public static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}