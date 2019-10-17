package dataFrame;

import java.lang.reflect.Array;
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
        List<ArrayList<Object>> dataFrame = new ArrayList<ArrayList<Object>>();

        for(int i = 0; i < mNumOfRows; i++)
        {
            ArrayList<Object> row = new ArrayList<Object>();

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
