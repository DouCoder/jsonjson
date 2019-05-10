package pack_relation;

import java.util.ArrayList;

public class ArrListDuplicatePrecess {
    public static void arrListDuplicateprocess(ArrayList<String> arrList){
        for (int i = 0; i < arrList.size()-1; i++) {
            for (int j = i+1; j < arrList.size(); j++) {
                if(arrList.get(i).equals(arrList.get(j))){
                    arrList.set(j,arrList.get(j)+"_");
                }
            }
        }
    }
}
