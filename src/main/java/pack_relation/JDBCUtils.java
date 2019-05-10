package pack_relation;

import java.sql.*;
import java.util.LinkedList;

public class JDBCUtils {

    private static String url="jdbc:mysql://localhost:3306/relation";
    private static String user="root";
    private static String pass="root";
    private static Connection conn=null;
    private static LinkedList<Connection> myPool=new LinkedList<Connection>();


    static {
        try {
            for (int i = 0; i < 10; i++) {
                Class.forName("com.mysql.jdbc.Driver");
                conn= DriverManager.getConnection(url,user,pass);
                myPool.add(conn);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public static Connection getConnection(){
        return myPool.removeFirst();
    }

    public static void release(Connection conn){
        if(conn!=null){
            myPool.add(conn);
        }
    }

    public static void release(Connection conn, PreparedStatement pstat, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        if(pstat!=null){
            try {
                pstat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            rs=null;
        }
        release(conn);

    }

    public static void release(Connection conn,PreparedStatement pstat){
        if(pstat!=null){
            try {
                pstat.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            pstat=null;
        }
        release(conn);
    }


/*
    //获取连接
    public static Connection getConnection(){
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

    */

}
