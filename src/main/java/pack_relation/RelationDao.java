package pack_relation;

import com.sun.xml.internal.ws.api.pipe.Tube;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RelationDao {
    public boolean creatTable(Relation relation,String tableName) {//建表的tablename用的是json文件的文件名X，不用文件名，改用pagetitle
        tableName=StringProcess.stringProcess(tableName);
        boolean flag=false;
        Connection connection=JDBCUtils.getConnection();
        PreparedStatement preparedStatement=null;

        String creatTableSql1="create table if not exists "+tableName+" ";
        String creatTableSql2=new String();
        String sql;
        for (String attrName:relation.getArrayListOfAttrName()
             ) {
            if(IsNumeric.isNumeric(attrName)){
                attrName+="_";
            }
            creatTableSql2+=attrName+" varchar(200), ";//这个地方好像varchar不够用啊？？
        }
        creatTableSql2=creatTableSql2.substring(0,creatTableSql2.length()-2);
        creatTableSql2="("+creatTableSql2;
        creatTableSql2=creatTableSql2+");";

        sql=creatTableSql1+creatTableSql2;

//        System.out.println(sql);//test

        try {
            preparedStatement=connection.prepareStatement(sql);
            if (preparedStatement.executeUpdate()>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(connection,preparedStatement);
        }




        return flag;

/*
        //分为几种情况：1）同表名同属性，2）同表名不同属性，3）不同表名  （这样分类不太行！！！）

        if(lastCreateSQL.equals(sql)){//同表名同属性
            System.out.println("create：同建表sql，不执行");
            //什么都不执行
            return lastCreateSQL;
        }else if(creatTableSql1.equals(lastCreateSQL.substring(0,creatTableSql1.length()))){//对比从开始截止到tablename之后，这一段相同，则重命名新表名
            sql=sql.substring(0,27)+"new_"+sql.substring(27);//在tablename前加一个new
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("creat：同名不同属性"+sql);
            return sql;
        }else{//不同表名，正常执行create sql即可
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("creat：不同表名执行"+sql);
            return sql;
        }
/*
/*
        //属性一样，直接不执行，属性不一样，新表前边加个0，（但是属性不一样有可能是表名也不一样的情况，这个时候不能加0_）
        if(sql.split("\\(")[sql.split("\\(").length-2].equals(lastCreateSQL.split("\\(")[lastCreateSQL.split("\\(").length-2])){
            //什么都不做
            System.out.println("create：不执行"+sql);
        }else{
            sql=sql.substring(0,27)+"0_"+sql.substring(27);//在tablename前加一个0_
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("create：执行了"+sql);
        }
        return sql;
*/

/*
        //分为几种情况：1）同属性不执行create sql，2）不同属性同表名，表名加new，3）不同属性不同表名，直接执行create sql （对比表名是无意义的，不如对比表名后的属性）
        //具体对比属性的方法是：将create sql以左括号split，取第length-2个(倒数第二个)
        //对比表名的方法是：creatTableSql1.equals(lastCreateSQL.substring(0,creatTableSql1.length()))
        if(sql.split("\\(")[sql.split("\\(").length-2].equals(lastCreateSQL.split("\\(")[lastCreateSQL.split("\\(").length-2])){
            //什么都不做
            System.out.println("create：同建表sql，不执行"+sql);
        }else if(creatTableSql1.equals(lastCreateSQL.substring(0,creatTableSql1.length()))){
            sql=sql.substring(0,27)+"0_"+sql.substring(27);//在tablename前加一个0
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("create：同名不同属性执行"+sql);
        }else{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
            System.out.println("creat：不同表名执行"+sql);
        }
        return sql;
*/
//把每一次执行create语句的sql给return了，在demo里边与上次return的sql进行对比，如果二者一样，则不执行sql了,但是如果没有执行create，return上一个lastsql
//这个地方要想办法：如果没有执行create，则不要更新上一个lastsql!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


    }




    public boolean insertRecord(Relation relation,String tableName)  {
        boolean flag=false;
        Connection connection=JDBCUtils.getConnection();
        PreparedStatement preparedStatement=null;
        String sql;


        String insertSql1="insert into "+tableName;
        String insertSql2;

        //对纯数字的列名进行修改
        ArrayList<String> attArrList=relation.getArrayListOfAttrName();
        for (int i = 0; i < attArrList.size(); i++) {
            if(IsNumeric.isNumeric(attArrList.get(i))){
                attArrList.set(i,attArrList.get(i)+"_");
            }
        }


        insertSql2=attArrList.toString();

        insertSql2="("+insertSql2.substring(1,insertSql2.length()-1)+") values";//去掉前后方括号，加上前后圆括号
        String insertSql3=new String();
        for (ArrayList<String> record:relation.getRecordsWithDoubleQuotes()
             ) {
//            System.out.println(record.toString());//test
            String s=new String();
            s=record.toString();
            insertSql3+="("+s.substring(1,s.length()-1)+"),";//去掉ArrayList的前后方括号，改成圆括号
//            System.out.println(insertSql3);//test

        }
        insertSql3=insertSql3.substring(0,insertSql3.length()-1);//去掉最后一个逗号
        sql=insertSql1+insertSql2+insertSql3+";";

//        System.out.println(sql);//test

        try {
            preparedStatement=connection.prepareStatement(sql);
            if(preparedStatement.execute(sql)){
                flag=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(connection,preparedStatement);
        }


        return flag;
    }


    public boolean alterTable(ArrayList<String> attArr,String tableName)  {
        boolean flag=false;
        Connection connection=JDBCUtils.getConnection();
        PreparedStatement preparedStatement=null;
        String altersql1;
        String altersql2="";
        String sql;

        altersql1="alter table "+tableName+" add ";
        for (String attrName:attArr
        ) {
            if(IsNumeric.isNumeric(attrName)){
                attrName+="_";
            }
            altersql2+=attrName+" varchar(200), ";//这个地方好像varchar不够用啊？？
        }
        altersql2=altersql2.substring(0,altersql2.length()-2);
        altersql2="("+altersql2+");";

        sql=altersql1+altersql2;

//        System.out.println(sql);//test


        try {
            preparedStatement=connection.prepareStatement(sql);
            if(preparedStatement.executeUpdate()>0){
                flag=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.release(connection,preparedStatement);
        }

        return flag;
    }
}
