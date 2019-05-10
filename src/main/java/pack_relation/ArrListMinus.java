package pack_relation;

import java.util.ArrayList;

public class ArrListMinus {
    public static ArrayList<String> arrListMinus(ArrayList<String> bigArrList,ArrayList<String> smallArrList){
        ArrayList arrList=new ArrayList();
        for (int i = 0; i < smallArrList.size(); i++) {
            if(bigArrList.contains(smallArrList.get(i))){

            }else {
                arrList.add(smallArrList.get(i));
            }
        }
        return arrList;
    }
}
