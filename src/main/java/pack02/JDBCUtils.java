package pack02;

import java.sql.*;

public class JDBCUtils {
    private static String url="jdbc:mysql://localhost:3306/jsonjson";
    private static String user="root";
    private static String pass="root";
    private static Connection conn=null;

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn= DriverManager.getConnection(url,user,pass);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    //获取连接
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源，带结果集的，
    public static void release(Connection conn, PreparedStatement pstat, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        release(conn,pstat);
    }
    //释放资源，不带结果集的
    public static void release(Connection conn,PreparedStatement pstat){
        if(pstat!=null){
            try {
                pstat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            pstat=null;
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn=null;
        }
    }
}
