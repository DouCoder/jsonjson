package pack02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class JsonDao {
    //将json文件存储到json01表格中
    public boolean insert(JsonClass jsonClass,String jsonFileName){
        boolean flag=false;
        PreparedStatement pstat=null;
        JDBCUtils jdbcUtils=new JDBCUtils();
        Connection conn=jdbcUtils.getConnection();
        String sql="insert into json01(filename,relation,pageTitle,title,url,hasHeader,HeaderPosition,tableType,tableNum,s3Link,recordEndOffset,recordOffset,tableOrientation,TableContextTimeStampBeforeTable,TableContextTimeStampAfterTable,lastModified,textBeforeTable,textAfterTable,hasKeyColumn,keyColumnIndex,headerRowIndex) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            pstat=conn.prepareStatement(sql);
            pstat.setString(1,jsonFileName);
            pstat.setString(2,jsonClass.getRelation().toString());
            pstat.setString(3,jsonClass.getPageTitle());
            pstat.setString(4,jsonClass.getTitle());
            pstat.setString(5,jsonClass.getUrl());
            pstat.setBoolean(6,jsonClass.isHasHeader());
            pstat.setString(7,jsonClass.getHeaderPosition());
            pstat.setString(8,jsonClass.getTableType());
            pstat.setInt(9,jsonClass.getTableNum());
            pstat.setString(10,jsonClass.getS3Link());
            pstat.setInt(11,jsonClass.getRecordEndOffset());
            pstat.setInt(12,jsonClass.getRecordOffset());
            pstat.setString(13,jsonClass.getTableOrientation());
            pstat.setString(14,jsonClass.getTableContextTimeStampBeforeTable());
            pstat.setString(15,jsonClass.getTableContextTimeStampAfterTable());
            pstat.setString(16,jsonClass.getLastModified());
            pstat.setString(17,jsonClass.getTextBeforeTable());
            pstat.setString(18,jsonClass.getTextAfterTable());
            pstat.setBoolean(19,jsonClass.isHasKeyColumn());
            pstat.setInt(20,jsonClass.getKeyColumnIndex());
            pstat.setInt(21,jsonClass.getHeaderRowIndex());

            if (pstat.executeUpdate()>0){
                flag=true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JDBCUtils.release(conn,pstat);
        }
        return flag;
    }

}
