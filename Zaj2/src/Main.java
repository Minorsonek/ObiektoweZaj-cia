import dataFrame.SparseDataFrame;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        var sdf = new SparseDataFrame(new String[]{"kol1","kol2"},
                new String[]{"int","int"},
                "0");

        var dataFrame = new ArrayList<List<Object>>();

        var firstRow = new ArrayList<Object>();
        firstRow.add(5);
        firstRow.add(7);
        firstRow.add(4);

        var secondRow = new ArrayList<Object>();
        secondRow.add(3);
        secondRow.add(0);
        secondRow.add(1);

        dataFrame.add(firstRow);
        dataFrame.add(secondRow);

        sdf.setDataFrame(dataFrame);

        System.out.println(sdf.toString());
    }
}
