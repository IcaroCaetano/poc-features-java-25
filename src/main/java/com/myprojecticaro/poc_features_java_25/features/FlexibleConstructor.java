package com.myprojecticaro.poc_features_java_25.features;

class ParentForFlexible {
private final int value;
ParentForFlexible(int value) {
this.value = value;
}
public int getValue() { return value; }
}


public class FlexibleConstructorExample extends ParentForFlexible {
private final int value;


public FlexibleConstructorExample(int value) {

if (value < 0) {
throw new IllegalArgumentException("value must be >= 0");
}
this.value = value * 1; 
super(value); 
}


public int getValue() { return value; }
}
