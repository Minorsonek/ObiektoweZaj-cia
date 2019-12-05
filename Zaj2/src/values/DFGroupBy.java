package values;

import dataFrame.DataFrameSimple;

import java.util.ArrayList;
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
            DataFrameSimple maximumRow = new DataFrameSimple
                    (mDataFramesColumnsNames, mDataFramesColumnsTypes);

            List<ArrayList<Value>> columns = new ArrayList<>();

            for (String columnName: mDataFramesColumnsNames)
            {
                Value maxValue = dataFrame.getColumn(columnName).get(0);

                for (Value val: dataFrame.getColumn(columnName))
                {
                    if (val.greaterThan(maxValue))
                    {
                        maxValue = val;
                    }
                }

                ArrayList<Value> newColumn = new ArrayList<Value>();
                newColumn.add(maxValue);

                columns.add(newColumn);

            }
            maximumRow.set(new ArrayList<>());

            finalDataFrame.add(maximumRow);
        }

        return finalDataFrame;
    }

    @Override
    public DataFrameSimple min() {
        DataFrameSimple finalDataFrame = new DataFrameSimple(mDataFramesColumnsNames,mDataFramesColumnsTypes);

        for (DataFrameSimple dataFrame : mInnerDataFrames)
        {
            DataFrameSimple minimumRow = null;
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
