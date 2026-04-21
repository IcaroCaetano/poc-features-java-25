package com.myprojecticaro.poc_features_java_25.features.core.model;

public sealed interface Result<T>
        permits Success, Failure {
}