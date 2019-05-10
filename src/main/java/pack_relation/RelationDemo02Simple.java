package pack_relation;

import com.google.gson.Gson;
import pack02.JavaFileRead;
import pack02.JsonClassSimple;

import java.io.File;
import java.util.ArrayList;

import static java.lang.Math.random;

public class RelationDemo02Simple {
    public static void main(String[] args) throws Exception {
        RelationDao relationDao=new RelationDao();
        String jsonRootPath="E:\\00\\table1\\";//jsonfile's root path
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
            System.out.println("json文件名："+jsonfilename);
            System.out.println("pagetitle:"+jsonObject.getPageTitle());//test
            //每次判断写成一个循环，查表名1，表名2...用while循环，用flag（初始为false）进行并操作，查表名的列明不对，就表名加一继续查，查不到表名就退出循环，建那个查不到的表


            pageTitle=jsonObject.getPageTitle();
            ArrayList<String> attFromDB=new ArrayList<String>();
            ArrayList<String> attFromRelation=new ArrayList<String>();
            attFromRelation=relation.getArrayListOfAttrName();
            int cnt=0;
            boolean flag=false;

            while (cnt<5){//对于一个json文件假定最多出现同一pagetitle对应不同列名的情况有五种
                flag=flag||IsTableExits.isTableExits(pageTitle);
                if(flag){//说明数据库中有这个同名表，但是具体列名一样不一样需要继续判断
                    attFromDB=GetAttArrFromDB.getAttArrFromDB(pageTitle);
                    if(attFromDB.equals(attFromRelation)){
                        relationDao.insertRecord(relation,pageTitle);
                    }
                    else {
                        pageTitle=pageTitle+"_";
                    }
                }
                cnt++;
            }
            relationDao.creatTable(relation,jsonObject.getPageTitle());
            relationDao.insertRecord(relation,jsonObject.getPageTitle());
            System.out.println(count+++"finished");

            /*
             * 三种情况
             * 1.不存在该表
             * 2.表名列名都一样
             * 3.有表名但是列名不一样
             * */




            //一个是从数据库中得到这个pagetitle对应的属性的ArrayList（已有的），一个是从当前解析的json对象的
            /*
            attFromDB=GetAttArrFromDB.getAttArrFromDB(jsonObject.getPageTitle());
            attFromRelation=relation.getArrayListOfAttrName();

            if(IsTableExits.isTableExits(jsonObject.getPageTitle())==false){
                relationDao.creatTable(relation,jsonObject.getPageTitle());
                relationDao.insertRecord(relation,jsonObject.getPageTitle());
                System.out.println(count+++"finished");
            }else if(attFromDB.equals(attFromRelation)){
                relationDao.insertRecord(relation,jsonObject.getPageTitle());
                System.out.println(count+++"finished");
            }else {
                int randomInt=(int)(Math.random()*100);
                relationDao.creatTable(relation,jsonObject.getPageTitle()+randomInt);
                relationDao.insertRecord(relation,jsonObject.getPageTitle()+randomInt);
                System.out.println("*********************"+count+++"finished*********************");
            }
*/

        }


    }
}
