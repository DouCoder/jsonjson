package pack_relation;

import pack02.JsonDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ABC {
    public static void main(String[] args) throws Exception {
        ArrayList<String> arr1=new ArrayList<String>();
        ArrayList<String> arr2=new ArrayList<String>();
        ArrayList<String> arr3=new ArrayList<String>();


        arr1.add("att1");
        arr1.add("att2");
        arr1.add("att3");
        arr1.add("att4");

        arr2.add("1");
        arr2.add("2");
        arr2.add("3");
        arr2.add("4");

        arr3.add("11");
        arr3.add("22");
        arr3.add("33");
        arr3.add("44");

        ArrayList<ArrayList<String>> arrarrVertical=new ArrayList<ArrayList<String>>();
        arrarrVertical.add(arr1);
        arrarrVertical.add(arr2);
        arrarrVertical.add(arr3);



        System.out.println("1***********************");


        ArrayList<String> arra1=new ArrayList<String>();
        ArrayList<String> arra2=new ArrayList<String>();
        ArrayList<String> arra3=new ArrayList<String>();


        arra1.add("att1");
        arra1.add("111");
        arra1.add("222");
        arra1.add("333");


        arra2.add("att2");
        arra2.add("111");
        arra2.add("222");
        arra2.add("333");

        arra3.add("att3");
        arra3.add("111");
        arra3.add("222");
        arra3.add("333");



        ArrayList<ArrayList<String>> arrarrHorizontal=new ArrayList<ArrayList<String>>();
        arrarrHorizontal.add(arra1);
        arrarrHorizontal.add(arra2);
        arrarrHorizontal.add(arra3);



        ArrayList<ArrayList<String>> arrarrHorizontal2=new ArrayList<ArrayList<String>>();
        arrarrHorizontal2.add(arra1);
        arrarrHorizontal2.add(arra2);
        arrarrHorizontal2.add(arra3);

        System.out.println(arrarrHorizontal.equals(arrarrHorizontal2));
    }
}
