package com.myprojecticaro.poc_features_java_25.features.core.model;

public record Failure<T>(String error) implements Result<T> {}