package dataFrame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SparseDataFrame extends DataFrame
{
    private String mSkipParameter;
    private List<List<COOValue>> mValues;
    private int mNumOfRows;
    private int mNumOfColumns;

    public SparseDataFrame(List<String> colNames, List<String> colTypes, String parameter)
    {
        super(colNames, colTypes);

        mSkipParameter = parameter;
        mValues = new ArrayList<>();
    }

    public void setDataFrame(List<List<Object>> dataFrame)
    {
        mNumOfRows = dataFrame.size();
        mNumOfColumns = dataFrame.get(0).size();

        for(var row: dataFrame)
        {
            var currentRowValues = new ArrayList<COOValue>();
            for(var i = 0; i < row.size(); i++)
            {
                var currentValue = row.get(i).toString();
                if (!currentValue.equals(mSkipParameter))
                {
                    var cooValue = new COOValue(Integer.toString(i), currentValue);
                    currentRowValues.add(cooValue);
                }
            }
            mValues.add(currentRowValues);
        }
    }

    public DataFrame toDense()
    {
        var dataFrame = new ArrayList<List<Object>>();

        for(var i = 0; i < mNumOfRows; i++)
        {
            var row = new ArrayList<Object>();

            for(var j = 0; j < mNumOfColumns; j++)
            {
                
            }

            dataFrame.add(row);
        }

        var dataFrameObject = new DataFrame(colNames, colTypes);
        dataFrameObject.setDataFrame(dataFrame);
        return dataFrameObject;
    }
}
