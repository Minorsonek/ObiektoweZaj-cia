package dataFrame;

import values.Value;

import java.util.ArrayList;
import java.util.List;

public class SparseDataFrame extends DataFrameSimple
{
    private String mSkipParameter;
    private List<List<COOValue>> mValues;
    private int mNumOfRows;
    private int mNumOfColumns;

    public SparseDataFrame(String[] columnNames, String[] columnTypes, String parameter)
    {
        super(columnNames, columnTypes);

        mSkipParameter = parameter;
        mValues = new ArrayList<>();
    }

    public void setDataFrame(List<List<Object>> dataFrame)
    {
        mNumOfRows = dataFrame.size();
        mNumOfColumns = dataFrame.get(0).size();

        for(List<Object> row: dataFrame)
        {
            List<COOValue> currentRowValues = new ArrayList<COOValue>();
            for(int i = 0; i < row.size(); i++)
            {
                String currentValue = row.get(i).toString();
                if (!currentValue.equals(mSkipParameter))
                {
                    COOValue cooValue = new COOValue(Integer.toString(i), currentValue);
                    currentRowValues.add(cooValue);
                }
            }
            mValues.add(currentRowValues);
        }
    }

    public DataFrameSimple toDense()
    {
        List<ArrayList<Value>> dataFrame = new ArrayList<ArrayList<Value>>();

        for(int i = 0; i < mNumOfRows; i++)
        {
            ArrayList<Value> row = new ArrayList<Value>();

            for(int j = 0; j < mNumOfColumns; j++)
            {
                
            }

            dataFrame.add(row);
        }

        DataFrameSimple dataFrameObject = new DataFrameSimple(mColumnNames, mColumnTypes);
        dataFrameObject.set(dataFrame);
        return dataFrameObject;
    }
}
