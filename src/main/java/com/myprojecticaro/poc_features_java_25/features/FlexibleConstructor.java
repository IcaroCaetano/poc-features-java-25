
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
// validações e lógica *antes* do super(...) — JEP 513 (flexible constructor bodies)
if (value < 0) {
throw new IllegalArgumentException("value must be >= 0");
}
this.value = value * 1; // lógica adicional possível
super(value); // chamada ao construtor da superclasse após pré-validação
}


public int getValue() { return value; }
}
