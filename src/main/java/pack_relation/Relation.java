package pack_relation;

import sun.rmi.runtime.NewThreadAction;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class Relation {
    public ArrayList<ArrayList<String>> relationTable;
    public int NumOfAttribution;
    public int NumOfRecord;
    private String tableOrientation;

    public Relation(ArrayList<ArrayList<String>> relationTable,String tableOrientation) {
        this.relationTable = relationTable;
        this.tableOrientation=tableOrientation;
    }

    public boolean isVertical() {

        if (tableOrientation.equals("VERTICAL")){
            return true;
        }else {
            return false;
        }
    }



    public int getNumOfAttribution() {
        if(isVertical()){
            return relationTable.get(0).size();
        }else {//tableOrientation=="HORIZONTAL"
            return relationTable.size();
        }
    }

    public ArrayList<String> getArrayListOfAttrName(){

        ArrayList<String> attList=new ArrayList<String>();

        if(isVertical()){
            for (int i = 0; i < relationTable.get(0).size(); i++) {
                attList.add(StringProcess.stringProcess(relationTable.get(0).get(i)));
//                relationTable.get(0).set(i,StringProcess.stringProcess(relationTable.get(0).get(i)));
            }
        }else {//HORIZONTAL
            for (int i = 0; i < relationTable.size(); i++) {
                attList.add(StringProcess.stringProcess(relationTable.get(i).get(0)));
            }
        }
        ArrListDuplicatePrecess.arrListDuplicateprocess(attList);
        for (int i = 0; i < attList.size(); i++) {
            if(IsNumeric.isNumeric(attList.get(i))){
                attList.set(i,attList.get(i)+"_");
            }
        }
        return attList;
    }

    public int getNumOfRecord() {
        if(isVertical()){
            return relationTable.size()-1;//减去属性行
        }else {
            return relationTable.get(0).size()-1;//减去属性行
        }
    }

    public ArrayList<ArrayList<String>> getRecords(){
        //注意：复制一个新的二维ArrayList，而不是重建一个引用！！！
        ArrayList<ArrayList<String>> newTable=(ArrayList<ArrayList<String>>) relationTable.clone();
        if(isVertical()){//vertical的只需要删掉第一行（属性行）就行了
            newTable.remove(0);
            return newTable;
        }else{//horizontal的比较麻烦，先整体对称，在删掉第一个record（伪）
            ArrayList<ArrayList<String>> records=new ArrayList<ArrayList<String>>();
            for (int i = 0; i < newTable.get(0).size(); i++) {//i代表括号里几个元素
                ArrayList<String> record=new ArrayList<String>();
                for (int j = 0; j < newTable.size(); j++) {//j代表几个括号
                    record.add(newTable.get(j).get(i));
                }
                records.add(record);
            }
            records.remove(0);
            return records;
        }
    }

    public ArrayList<ArrayList<String>> getRecordsWithDoubleQuotes(){
        //注意：复制一个新的二维ArrayList，而不是重建一个引用！！！
        ArrayList<ArrayList<String>> newTable=(ArrayList<ArrayList<String>>) relationTable.clone();
        if(isVertical()){//vertical的只需要删掉第一行（属性行）就行了
            newTable.remove(0);
        }else{//horizontal的比较麻烦，先整体对称，在删掉第一个record（伪）
            ArrayList<ArrayList<String>> records=new ArrayList<ArrayList<String>>();
            for (int i = 0; i < newTable.get(0).size(); i++) {//i代表括号里几个元素
                ArrayList<String> record=new ArrayList<String>();
                for (int j = 0; j < newTable.size(); j++) {//j代表几个括号
                    record.add(newTable.get(j).get(i));
                }
                records.add(record);
            }
            records.remove(0);
            newTable=records;
        }
        //对newtable中的每一个元素都加上双引号
        ArrayList<ArrayList<String>> newnewTable=new ArrayList<ArrayList<String>>();
        for (int i = 0; i < newTable.size(); i++) {
            ArrayList<String> aRow=new ArrayList<String>();
            for (int j = 0; j < newTable.get(0).size(); j++) {
                aRow.add("\""+newTable.get(i).get(j)+"\"");
            }
            newnewTable.add(aRow);
        }
        return newnewTable;
    }
}
