package pack_relation;

import java.util.ArrayList;

public class ArrlistContain {
    public static boolean arrlistContain(ArrayList<String> bigArrList,ArrayList<String> smallArrList){
        boolean flag=true;
        for (int i = 0; i < smallArrList.size(); i++) {
            flag=flag && bigArrList.contains(smallArrList.get(i));
        }
        return flag;
    }
}
