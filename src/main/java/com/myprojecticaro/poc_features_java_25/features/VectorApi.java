package com.myprojecticaro.poc_features_java_25.features;

import jdk.incubator.vector.IntVector;
import jdk.incubator.vector.VectorSpecies;

/**
 * Demonstrates the Vector API, an incubating feature in Java 25.
 * <p>
 * The Vector API provides a way to express vector computations that
 * reliably compile at runtime to optimal vector instructions on supported
 * hardware (e.g., SIMD instructions), enabling significant performance
 * improvements for data-parallel operations.
 * </p>
 *
 * <p>
 * This example demonstrates how to:
 * <ul>
 *   <li>Create two integer arrays</li>
 *   <li>Load them into {@link IntVector} instances</li>
 *   <li>Add the vectors element-wise</li>
 *   <li>Store the result back into a standard array</li>
 * </ul>
 * </p>
 *
 * <pre>
 * Example output:
 *  vector add result: 11 22 33 44 ...
 * </pre>
 */
public class VectorApi {

    /**
     * The preferred species for {@link IntVector}, which represents the
     * optimal vector size supported by the current hardware platform.
     */
    private static final VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    /**
     * Runs a demonstration of the Vector API.
     * <p>
     * Two arrays of integers are created and loaded into vectors.
     * The vectors are added element-wise, and the result is written
     * back to a new array.
     * </p>
     *
     * <pre>
     * Example:
     *   a = [1, 2, 3, ...]
     *   b = [10, 20, 30, ...]
     *   result = [11, 22, 33, ...]
     * </pre>
     */
    public static void runExample() {

        int length = SPECIES.length();
        int[] a = new int[length];
        int[] b = new int[length];

        for (int i = 0; i < length; i++) {
            a[i] = i + 1;
            b[i] = (i + 1) * 10;
        }

        var va = IntVector.fromArray(SPECIES, a, 0);
        var vb = IntVector.fromArray(SPECIES, b, 0);

        var vc = va.add(vb);
        int[] result = new int[length];
        vc.intoArray(result, 0);

        System.out.print(" vector add result: ");
        for (int v : result) System.out.print(v + " ");
        System.out.println();
    }
}
