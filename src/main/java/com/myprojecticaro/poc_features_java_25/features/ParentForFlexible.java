package com.myprojecticaro.poc_features_java_25.features;

/**
 * Simple parent class used to demonstrate flexible constructor invocation
 * in Java 25 preview features.
 * <p>
 * This class holds an immutable integer value provided during construction. 
 * It serves as a base class for {@link FlexibleConstructor}, showcasing how 
 * subclasses can call the parent constructor with arguments and apply 
 * additional validation or transformation logic.
 * </p>
 */
class ParentForFlexible {

    /**
     * Immutable value initialized via the constructor.
     */
    private final int value;

    /**
     * Creates a new {@code ParentForFlexible} instance with the given value.
     *
     * @param value the integer value to be stored
     */
    ParentForFlexible(int value) {
        this.value = value;
    }

    /**
     * Returns the stored integer value.
     *
     * @return the integer value
     */
    public int getValue() {
        return value;
    }
}
