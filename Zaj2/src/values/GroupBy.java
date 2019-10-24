package values;

import dataFrame.DataFrameSimple;

public interface GroupBy
{
    DataFrameSimple max();
    DataFrameSimple min();
    DataFrameSimple mean();
    DataFrameSimple std();
    DataFrameSimple sum();
    DataFrameSimple var();
    DataFrameSimple apply(Applyable applyable);
}
