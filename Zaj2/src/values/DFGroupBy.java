package values;

import dataFrame.DataFrameSimple;

import java.util.List;

public class DFGroupBy implements GroupBy
{
    private List<DataFrameSimple> mInnerDataFrames;
    private String[] mDataFramesColumnsNames;
    private String[] mDataFramesColumnsTypes;
    private String mGroupedColumnName;

    public DFGroupBy(List<DataFrameSimple> dataFrames, String colName, String[] colNames, String[] colTypes)
    {
        mInnerDataFrames = dataFrames;
        mGroupedColumnName = colName;
        mDataFramesColumnsNames = colNames;
        mDataFramesColumnsTypes = colTypes;
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
    public DataFrameSimple apply(Applyable applyable){
        DataFrameSimple finalDataFrame = new DataFrameSimple(mDataFramesColumnsNames,mDataFramesColumnsTypes);

        for (DataFrameSimple dataFrame : mInnerDataFrames)
        {
            finalDataFrame.add(applyable.apply(dataFrame));
        }

        return finalDataFrame;
    }
}
