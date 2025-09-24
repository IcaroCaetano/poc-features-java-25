package com.myprojecticaro.poc_features_java_25.features;

import java.util.Base64;

public final class PemUtils {
private PemUtils() {}


public static String wrapPem(String type, String base64Body) {
  
  StringBuilder sb = new StringBuilder();
  sb.append("-----BEGIN ").append(type).append("-----\n");

  int i = 0;
  
  while (i < base64Body.length()) {
    int end = Math.min(i + 64, base64Body.length());
    sb.append(base64Body, i, end).append('\n');
    i = end;
  }
  
  sb.append("-----END ").append(type).append("-----\n");

  return sb.toString();
  
}

  public static String encodeToBase64(String plain) {
    return Base64.getEncoder().encodeToString(plain.getBytes());
  }
}
