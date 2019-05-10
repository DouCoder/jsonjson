package pack_relation;

import com.google.gson.Gson;
import pack02.JavaFileRead;
import pack02.JsonClass;
import pack02.JsonDao;

import java.io.File;
import java.sql.SQLException;

public class RelationDemo01 {
    public static void main(String[] args) throws Exception {
        RelationDao relationDao=new RelationDao();
        String jsonRootPath="D:\\00\\table1\\";//jsonfile's root path
        File file = new File(jsonRootPath);
        String[] namelist=file.list();
        Gson gson = new Gson();
        int count=1;//计数器
        String pagetitle="";
        for (String jsonfilename:namelist
                ) {
            String text=JavaFileRead.javaFileRead(jsonRootPath+jsonfilename);
            JsonClass jsonClass = gson.fromJson(text,JsonClass.class);
            Relation relation=new Relation(jsonClass.getRelation(),jsonClass.getTableOrientation());
            pagetitle=jsonClass.getPageTitle();

            System.out.println("json名字："+pagetitle);
            relationDao.creatTable(relation,pagetitle);//done
            relationDao.insertRecord(relation,pagetitle);//insert会出现问题：若pagetitle一样，但是relation表的结构不一样，插入新的relation的时候会出错
            System.out.println("finished"+count++);

        }


    }
}
