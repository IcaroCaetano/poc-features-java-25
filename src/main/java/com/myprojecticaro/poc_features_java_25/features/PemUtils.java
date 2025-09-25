package com.myprojecticaro.poc_features_java_25.features;

import java.util.Base64;

/**
 * Utility class for working with PEM (Privacy-Enhanced Mail) encoded data.
 * <p>
 * PEM is a widely used format for encoding cryptographic keys and certificates 
 * in a Base64-encoded block surrounded by header and footer lines.
 * </p>
 *
 * <p>
 * This class provides helper methods to:
 * <ul>
 *   <li>Wrap a Base64 string into PEM format with proper headers and line breaks</li>
 *   <li>Encode plain strings into Base64</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class cannot be instantiated.
 * </p>
 */
public final class PemUtils {

    /**
     * Private constructor to prevent instantiation.
     */
    private PemUtils() {}

    /**
     * Wraps a Base64-encoded string into a PEM block with the specified type.
     * <p>
     * The body will be split into lines of 64 characters, as per PEM 
     * formatting rules, and surrounded by {@code BEGIN} and {@code END} markers.
     * </p>
     *
     * <pre>
     * Example:
     * -----BEGIN CERTIFICATE-----
     * (Base64 data split into 64-char lines)
     * -----END CERTIFICATE-----
     * </pre>
     *
     * @param type the PEM type, e.g., {@code CERTIFICATE}, {@code PRIVATE KEY}
     * @param base64Body the Base64-encoded content
     * @return a properly formatted PEM string
     */
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

    /**
     * Encodes a plain text string into Base64.
     *
     * @param plain the input string
     * @return the Base64-encoded representation of the input
     */
    public static String encodeToBase64(String plain) {
        return Base64.getEncoder().encodeToString(plain.getBytes());
    }
}
