package pack_relation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAttArrFromDB {
    public static ArrayList<String> getAttArrFromDB(String tableName)  {
        Connection connection=JDBCUtils.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        ArrayList<String> attarr=new ArrayList<String>();

        try{
            preparedStatement=connection.prepareStatement("select column_name from information_schema.columns where table_name='"+tableName+"\';");
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                attarr.add(resultSet.getString(1));
//            System.out.println(resultSet.getString(1));//test
            }
        }catch (Exception e){

        }finally {
            JDBCUtils.release(connection,preparedStatement,resultSet);

        }

        return attarr;
    }
}
