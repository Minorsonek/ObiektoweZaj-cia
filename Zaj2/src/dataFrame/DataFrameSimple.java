package dataFrame;

import values.StringValue;
import values.Value;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataFrameSimple {
    private List<ArrayList<Value>> mColumns;
    protected String[] mColumnNames;
    protected String[] mColumnTypes;

    public DataFrameSimple(String[] columnNames, String[] columnTypes) {
        mColumnNames = columnNames;
        mColumnTypes = columnTypes;
    }

    /*
    – zwracającą ilość wierszy w całej DF (uwaga – DF nie może mieć jednej z kolumn dłuższej niż pozostałe
     */
    public int size()
    {
        ArrayList<Value> firstColumn = mColumns.get(0);

        if (firstColumn == null) {
            return 0;
        }

        return firstColumn.size();
    }

    /*
     – zwracającą kolumnę o podanej nazwie
     */
    public ArrayList<Value> get(String columnName)
    {
        int columnIndex = -1;

        for (int i = 0; i < mColumnNames.length; i++) {
            if (mColumnNames[i].equals(columnName)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex == -1) {
            return null;
        }

        return mColumns.get(columnIndex);
    }

    /*
    – zwracającą nową DataFrame z kolumnami podanymi jako parametry. W zależności od wartości parametru copy albo tworzona jest głęboka kopia, albo płytka.
     */
    public DataFrameSimple get(String[] colNames, boolean copy)
    {
        List<ArrayList<Value>> columns = new ArrayList<ArrayList<Value>>();
        String[] colTypes = new String[colNames.length];

        for (int i = 0; i < colNames.length; i++) {
            String currentColName = colNames[i];
            ArrayList<Value> currentColumn = get(currentColName);

            for (int j = 0; j < mColumnNames.length; j++)
            {
                if (mColumnNames[j].equals(currentColName))
                {
                    colTypes[i] = mColumnTypes[j];
                    break;
                }
            }

            if(copy)
            {
                ArrayList<Value> copiedColumn = new ArrayList<>();

                for (Value x: currentColumn){
                    copiedColumn.add(new StringValue(new StringBuilder(x.toString()).toString()));
                }

                columns.add(copiedColumn);
            }
            else
            {
                columns.add(currentColumn);
            }
        }

        DataFrameSimple dataFrame = new DataFrameSimple(colNames, colTypes);

        dataFrame.set(columns);

        return dataFrame;
    }

    /*
     – zwracającą wiersz o podanym indeksie (jako nową DataFrame)
     */
    public DataFrameSimple iloc(int i)
    {
        DataFrameSimple rowDataFrame = new DataFrameSimple(mColumnNames, mColumnTypes);

        List<ArrayList<Value>> columnsForRowDataFrame = getRowsFromTo(i, i);

        rowDataFrame.set(columnsForRowDataFrame);

        return rowDataFrame;
    }

    /*
     – zwracającą nową DataFrame z wierszami z podanego zakresu
     */
    public DataFrameSimple iloc(int from, int to)
    {
        DataFrameSimple rowDataFrame = new DataFrameSimple(mColumnNames, mColumnTypes);

        List<ArrayList<Value>> columnsForRowDataFrame = getRowsFromTo(from, to);

        rowDataFrame.set(columnsForRowDataFrame);

        return rowDataFrame;
    }

    public void set(List<ArrayList<Value>> columns)
    {
        mColumns = columns;
    }

    private List<ArrayList<Value>> getRowsFromTo(int from, int to)
    {
        List<ArrayList<Value>> columns = new ArrayList<ArrayList<Value>>();

        for (ArrayList<Value> column: mColumns)
        {
            ArrayList<Value> newColumn = new ArrayList<>();

            for (int i = from; i <= to; i++)
            {
                Value valueAtIndex = column.get(i);
                newColumn.add(valueAtIndex);
            }

            columns.add(newColumn);
        }

        return columns;
    }
}
