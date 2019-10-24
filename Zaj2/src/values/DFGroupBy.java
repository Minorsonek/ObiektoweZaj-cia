package values;

import dataFrame.DataFrameSimple;

import java.util.List;

public class DFGroupBy implements GroupBy
{
    private List<DataFrameSimple> mInnerDataFrames;
    private String[] mDataFramesColumnsNames;
    private String[] mDataFramesColumnsTypes;
    private String mGroupedColumnName;

    public DFGroupBy(List<DataFrameSimple> dataFrames, String colName)
    {
        mInnerDataFrames = dataFrames;
        mGroupedColumnName = colName;
    }

    @Override
    public DataFrameSimple max() {
        DataFrameSimple finalDataFrame = new DataFrameSimple(mDataFramesColumnsNames,mDataFramesColumnsTypes);

        for (DataFrameSimple dataFrame : mInnerDataFrames)
        {
            DataFrameSimple maximumRow;

            

            finalDataFrame.add(maximumRow);
        }

        return finalDataFrame;
    }

    @Override
    public DataFrameSimple min() {
        DataFrameSimple finalDataFrame = new DataFrameSimple(mDataFramesColumnsNames,mDataFramesColumnsTypes);

        for (DataFrameSimple dataFrame : mInnerDataFrames)
        {
            DataFrameSimple minimumRow;
            finalDataFrame.add(minimumRow);
        }

        return finalDataFrame;
    }

    @Override
    public DataFrameSimple mean() {
        return null;
    }

    @Override
    public DataFrameSimple std() {
        return null;
    }

    @Override
    public DataFrameSimple sum() {
        return null;
    }

    @Override
    public DataFrameSimple var() {
        return null;
    }

    @Override
    public DataFrameSimple apply(Applyable applyable) {
        return null;
    }
}
