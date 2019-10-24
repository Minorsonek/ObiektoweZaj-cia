package values;

public interface Value extends Cloneable
{
    String toString();
    Value add(Value value) throws Exception;
    Value subtract(Value value) throws Exception;
    Value multiply(Value value) throws Exception;
    Value divide(Value value) throws Exception;
    Value power(Value value) throws Exception;
    boolean equals(Value value);
    boolean lessThan(Value value);
    boolean greaterThan(Value value);
    boolean notEquals(Value value);
    boolean equals(Object other);
    int hashCode();
    Value create(String s);
}
