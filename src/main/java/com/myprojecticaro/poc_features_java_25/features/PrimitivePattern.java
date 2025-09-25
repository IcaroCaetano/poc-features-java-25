package com.myprojecticaro.poc_features_java_25.features;

public class PrimitivePattern {
  
  public static void runExample() {
  
    Object[] inputs = { 10, 3.14, "hello", (short)7 };


  for (Object o : inputs) {
    String result = switch (o) { 
    case int i -> "int: " + i;
    case double d -> "double: " + d;
    case short s -> "short: " + s;
    case String s -> "string: " + s;
    default -> "unknown: " + o;
  };

    System.out.println(" -> " + result);

  }

  }
}
