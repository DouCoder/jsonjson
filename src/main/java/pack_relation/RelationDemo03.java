package pack_relation;

import com.google.gson.Gson;
import org.omg.CosNaming.IstringHelper;
import pack02.JavaFileRead;
import pack02.JsonClassSimple;

import java.io.File;
import java.util.ArrayList;

import static java.lang.Math.random;

public class RelationDemo03 {
    public static void main(String[] args) throws Exception {
        RelationDao relationDao=new RelationDao();
        String jsonRootPath="E:\\00\\0\\";//jsonfile's root path
        File file = new File(jsonRootPath);
        String[] namelist=file.list();
        Gson gson = new Gson();
        int count=1;//计数器

        for (String jsonfilename:namelist
        ) {
            String text=JavaFileRead.javaFileRead(jsonRootPath+jsonfilename);
            JsonClassSimple jsonObject = gson.fromJson(text,JsonClassSimple.class);
            Relation relation=new Relation(jsonObject.getRelation(),jsonObject.getTableOrientation());
            String pageTitle=new String();
//            System.out.println("json文件名："+jsonfilename);//test
//            System.out.println("pagetitle:"+jsonObject.getPageTitle());//test


            //去数据库里边查，当前pagetitle是否有表名，如果有则看属性名是否为包含关系，如果是，直接插入，如果不是，alter原表,增加字段

            pageTitle=jsonObject.getPageTitle();
            ArrayList<String> attFromDB=new ArrayList<String>();
            ArrayList<String> attFromRelation=new ArrayList<String>();
            attFromRelation=relation.getArrayListOfAttrName();
            attFromDB=GetAttArrFromDB.getAttArrFromDB(pageTitle);

            if(IsTableExits.isTableExits(pageTitle)){
                //存在表名，继续进行判断
                if(ArrlistContain.arrlistContain(attFromDB,attFromRelation)){
                    //如果数据库已经存在比当前relation更丰富的表，则直接插入
                    relationDao.insertRecord(relation,pageTitle);
                    System.out.println("******************"+count+++"finished"+"******************");

                }else{
                    //表名存在，但是列名不一样
                    ArrayList<String> minusAttarr=new ArrayList<String>();
                    minusAttarr=ArrListMinus.arrListMinus(attFromDB,attFromRelation);
                    relationDao.alterTable(minusAttarr,pageTitle);//这个地方alter，必须是原表格没有的列名，如果alter增加了已经存在的列名，会出现duplicate错误
                    relationDao.insertRecord(relation,pageTitle);
                    System.out.println("******************"+count+++"finished"+"******************");
                }
            }else {
                //不存在该表名，直接建新表并插入
                relationDao.creatTable(relation,pageTitle);
                relationDao.insertRecord(relation,pageTitle);
                System.out.println("******************"+count+++"finished"+"******************");
            }



        }


    }
}
