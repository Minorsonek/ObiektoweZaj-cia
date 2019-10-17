package values;

public class Integer implements Value
{
    public int IntValue;

    public Integer(int value)
    {
        IntValue = value;
    }

    @Override
    public String toString() {
        return java.lang.Integer.toString(IntValue);
    }

    @Override
    public Value add(Value value) throws Exception {

        Integer intValue = getTypeFromValue(value, "Tried to add two different value types");

        return new Integer(intValue.IntValue + IntValue);
    }

    @Override
    public Value subtract(Value value) throws Exception {

        Integer intValue = getTypeFromValue(value, "Tried to subtract two different value types");

        return new Integer(intValue.IntValue - IntValue);
    }

    @Override
    public Value multiply(Value value) throws Exception {

        Integer intValue = getTypeFromValue(value, "Tried to multiply two different value types");

        return new Integer(intValue.IntValue * IntValue);
    }

    @Override
    public Value divide(Value value) throws Exception {

        Integer intValue = getTypeFromValue(value, "Tried to divide two different value types");

        return new Integer(intValue.IntValue / IntValue);
    }

    @Override
    public Value power(Value value) throws Exception {

        Integer intValue = getTypeFromValue(value, "Tried to power two different value types");

        return new Integer((int)(Math.pow(intValue.IntValue, IntValue)));
    }

    @Override
    public boolean equals(Value value) {
        if (!(value instanceof Integer))
        {
            return false;
        }

        Integer intValue = (Integer)value;

        return intValue.IntValue == IntValue;
    }

    @Override
    public boolean lessThan(Value value) {
        if (!(value instanceof Integer))
        {
            return false;
        }

        Integer intValue = (Integer)value;

        return intValue.IntValue < IntValue;
    }

    @Override
    public boolean greaterThan(Value value) {
        if (!(value instanceof Integer))
        {
            return false;
        }

        Integer intValue = (Integer)value;

        return intValue.IntValue > IntValue;
    }

    @Override
    public boolean notEquals(Value value) {
        return !equals(value);
    }

    @Override
    public boolean equals(Object other)
    {
        if (!(other instanceof Integer))
        {
            return false;
        }

        Integer intValue = (Integer)other;

        return intValue.IntValue == IntValue;
    }

    @Override
    public int hashCode()
    {
        return this.hashCode();
    }

    @Override
    public Value create(String s) {
        int valueAsInt = java.lang.Integer.getInteger(s);

        return new Integer(valueAsInt);
    }

    private Integer getTypeFromValue(Value value, String errorMessage) throws Exception
    {
        if (!(value instanceof Integer))
        {
            throw new Exception(errorMessage);
        }

        return (Integer)value;
    }
}
