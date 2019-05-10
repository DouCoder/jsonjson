package pack02;


import sun.net.www.protocol.http.HttpURLConnection;

import java.util.ArrayList;

//用于存储json文件中的那个表，是ArrayList的嵌套
public class Relation {
    private ArrayList<ArrayList<String>> relation=new ArrayList<ArrayList<String>>();

    public boolean add(ArrayList<String> newArray){
        relation.add(newArray);
        return true;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "relation=" + relation +
                '}';
    }
}
