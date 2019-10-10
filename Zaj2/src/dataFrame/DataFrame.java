package dataFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DataFrame {

    private List<List<Object>> dataFrame;
    protected List<String> colNames;
    protected List<String> colTypes;

    // kolejnosc nazw adekwatna do kolejnosci list w ramce
    public DataFrame(List<String> colNames, List<String> colTypes) {
        this.colNames = colNames;
        this.colNames = colTypes;

        this.dataFrame = new ArrayList<>();
    }

    public List<Object> get(String name){
        System.out.println("xdd");
        boolean contains=colNames.contains(name);
        if(contains){
            int index=colNames.indexOf(name);
            return dataFrame.get(index);
        }
        return null;
    }

    public DataFrame get(String[] cols, boolean copy){
        int[] exising = new int[colNames.size()];
        String[] newNames = new String[cols.length];

        //zerowanie indeksów
        for(int i=0; i<exising.length;i++){
            exising[i]=0;
        }

        for(int i=0; i<cols.length; i++){
            if(colNames.contains(cols[i])){
                //index typu
                int index=colNames.indexOf(cols[i]);
                newNames[i]=colTypes.get(index).toString();
                exising[index]=1;
            }
        }
        //tworzenie listy list z danymi;
        List<List<Object>> data=new ArrayList<>(cols.length);

        if(copy) {
            for (int i = 0; i < exising.length; i++) {
                if (exising[i] == 1) {
                    List<Object> temp=new ArrayList<>(cols.length);
                    //nowe stringi nie referencje
                    for (var x:dataFrame.get(i)){
                        temp.add(new StringBuilder(x.toString()).toString());
                    }
                }
            }
        }
        else {
            for (int i = 0; i < exising.length; i++) {
                if (exising[i] == 1) {
                    data.add(dataFrame.get(i));
                }
            }
        }
        DataFrame  newDf = new DataFrame (cols, newNames);
        newDf.setDataFrame(data);

        return newDf;
    }

    public DataFrame iloc(int index){
        String name=colNames.get(index).toString();
        String type=colTypes.get(index).toString();
        DataFrame newDf=new DataFrame (new String[]{name},new String[]{type});

        List<List<Object>> data=new ArrayList<>();
        for(var x:dataFrame) {
            //wyłuskanie wartosci z danego wiersza
            ArrayList<Object> arry=new ArrayList<>();
            arry.add(x.get(index));

            data.add(arry);
        }
        newDf.setDataFrame(data);
        return newDf;
    }

    public DataFrame  iloc(int from, int to) {
        String [] newColNames=new String[to-from];
        String [] newTypeNames=new String[to-from];
//        for(int i=from; i<=to; i++){
//            int iterator=0;
//            newColNames[iterator]=colNames.get(i);
//            newTypeNames[iterator]=colTypes.get(i);
//            iterator++;
//
//        }
        List<List<Object>> data=new ArrayList<>();
        for(var x:dataFrame){

            List<Object> arry=new ArrayList<>();
            for(int i=from; i<to+1; i++){

                arry.add(x.get(i));
            }

            data.add(arry);
        }

        DataFrame newDf=new DataFrame (newColNames,newTypeNames);

        //List<List<String>> data=new ArrayList<>();
//        for(int i=from; i<=to; i++) {
//            data.add(dataFrame.get(i));
//        }

        newDf.setDataFrame(data);
        return newDf;

    }

    @Override
    public String toString() {
        List<Object> content=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0; i<dataFrame.size(); i++){
            for(var x:dataFrame.get(i)){
                sb.append(x);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<List<Object>> getDataFrame() {
        return dataFrame;
    }

    public void setDataFrame(List<List<Object>> dataFrame) {
        this.dataFrame = dataFrame;
    }
}
