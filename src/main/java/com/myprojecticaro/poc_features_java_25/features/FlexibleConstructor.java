package com.myprojecticaro.poc_features_java_25.features;

/**
 * Demonstrates the Java 25 feature: <b>Flexible Constructor Bodies</b> (JEP 513).
 * <p>
 * This class extends {@link ParentForFlexible} and shows how constructor logic
 * (such as validations or computations) can be placed <i>before</i> the call to
 * {@code super(...)}.
 * </p>
 *
 * <p>Key points:</p>
 * <ul>
 *   <li>Validates the constructor argument before invoking the superclass constructor.</li>
 *   <li>Allows pre-processing or adjustment of values before passing them to the parent class.</li>
 *   <li>Provides a getter to access the stored value.</li>
 * </ul>
 */
public class FlexibleConstructor extends ParentForFlexible {

    /**
     * Holds the validated and possibly transformed value.
     */
    private final int value;

    /**
     * Constructs a new {@code FlexibleConstructor}.
     *
     * <p>Validates the input value before calling the parent constructor:</p>
     * <ul>
     *   <li>If the value is negative, an {@link IllegalArgumentException} is thrown.</li>
     *   <li>The value is multiplied by 1 (placeholder for additional logic)
     *       before being assigned to this instance.</li>
     * </ul>
     *
     * @param value the integer to be validated and stored
     * @throws IllegalArgumentException if {@code value} is less than 0
     */
    public FlexibleConstructor(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("value must be >= 0");
        }
        this.value = value * 1; // preprocessing step (can be replaced with real logic)
        super(value);
    }

    /**
     * Returns the validated value stored in this object.
     *
     * @return the validated and stored integer
     */
    public int getValue() {
        return value;
    }
}
