package values;

public class StringValue implements Value
{
    private String mStringValue;

    public StringValue(String value)
    {
        mStringValue = value;
    }

    @Override
    public String toString() {
        return mStringValue;
    }

    @Override
    public Value add(Value value) throws Exception {

        if (!(value instanceof StringValue))
        {
            throw new Exception("Tried to add two different value types");
        }

        StringValue stringValue = (StringValue)value;

        return new StringValue(stringValue.toString() + mStringValue);
    }

    @Override
    public Value subtract(Value value) throws Exception {
        throw new Exception("Tried to subtract strings");
    }

    @Override
    public Value multiply(Value value) throws Exception {
        throw new Exception("Tried to multiply strings");
    }

    @Override
    public Value divide(Value value) throws Exception {
        throw new Exception("Tried to divide strings");
    }

    @Override
    public Value power(Value value) throws Exception {
        throw new Exception("Tried to power strings");
    }

    @Override
    public boolean equals(Value value) {
        return equals(value);
    }

    @Override
    public boolean lessThan(Value value) {
        return false;
    }

    @Override
    public boolean greaterThan(Value value) {
        return false;
    }

    @Override
    public boolean notEquals(Value value) {
        return !equals(value);
    }

    @Override
    public boolean equals(Object value)
    {
        if (!(value instanceof StringValue))
        {
            return false;
        }

        StringValue stringValue = (StringValue)value;

        return stringValue.toString().equals(mStringValue);
    }

    @Override
    public int hashCode()
    {
        return this.hashCode();
    }

    @Override
    public Value create(String s) {
        return new StringValue(s);
    }
}
