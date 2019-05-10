package pack02;

import com.google.gson.*;

import java.io.File;

public class GsonDemo01 {
    public static void main(String[] args) {
        JsonDao jsonDao=new JsonDao();
        String jsonRootPath="d:/0000/";//jsonfile's root path
        File file = new File(jsonRootPath);
        String[] namelist=file.list();
        for (String jsonfilename:namelist
             ) {
            String text=JavaFileRead.javaFileRead(jsonRootPath+jsonfilename);
//        System.out.println(text);
            Gson gson = new Gson();
            JsonClass jsonClass = gson.fromJson(text,JsonClass.class);
//        System.out.println(jsonClass.toString());
//        System.out.println(jsonClass.getRelation());//getRelation方法返回的就是一个二维的ArrayList
            jsonDao.insert(jsonClass,jsonfilename);




        }




    }
}
