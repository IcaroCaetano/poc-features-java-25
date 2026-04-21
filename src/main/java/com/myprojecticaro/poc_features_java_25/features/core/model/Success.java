package com.myprojecticaro.poc_features_java_25.features.core.model;

public record Success<T>(T data) implements Result<T> {}