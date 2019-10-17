package dataFrame;

import values.Value;

public final class COOValue implements Value
{
    private String mIndex;
    private String mValue;

    public COOValue(String index, String value)
    {
        mIndex = index;
        mValue = value;
    }

    @Override
    public Value add(Value value) throws Exception {
        return null;
    }

    @Override
    public Value subtract(Value value) throws Exception {
        return null;
    }

    @Override
    public Value multiply(Value value) throws Exception {
        return null;
    }

    @Override
    public Value divide(Value value) throws Exception {
        return null;
    }

    @Override
    public Value power(Value value) throws Exception {
        return null;
    }

    @Override
    public boolean equals(Value value) {
        return false;
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
        return false;
    }

    @Override
    public Value create(String s) {
        return null;
    }
}
