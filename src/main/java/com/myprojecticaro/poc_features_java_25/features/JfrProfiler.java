package com.myprojecticaro.poc_features_java_25.features;

/**
 * Utility class to demonstrate integration with Java Flight Recorder (JFR).
 * <p>
 * This class provides stub methods for starting and stopping a JFR recording. 
 * In a real-world scenario, enabling JFR requires JVM flags 
 * (e.g., {@code -XX:StartFlightRecording} or using the JFR APIs directly).
 * </p>
 *
 * <p>
 * The purpose of this class in the POC is to simulate how developers could 
 * integrate JFR profiling into their applications for performance and 
 * diagnostic purposes in Java 25.
 * </p>
 */
public class JfrProfiler {

    /**
     * Starts a Java Flight Recorder (JFR) recording.
     * <p>
     * This is a stub implementation for demonstration purposes. 
     * To enable real JFR recording, configure JVM flags or 
     * use {@code jdk.jfr.Recording}.
     * </p>
     */
    public static void startRecording() {
        System.out.println(" (stub) start JFR recording - enable via JVM flags");
    }

    /**
     * Stops a Java Flight Recorder (JFR) recording.
     * <p>
     * This is a stub implementation for demonstration purposes. 
     * Use {@code Recording.stop()} in a real JFR integration.
     * </p>
     */
    public static void stopRecording() {
        System.out.println(" (stub) stop JFR recording");
    }
}
