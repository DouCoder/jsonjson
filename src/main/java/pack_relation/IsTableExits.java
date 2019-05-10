package pack_relation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IsTableExits {
    public static boolean isTableExits(String tableName) throws SQLException {
        Connection connection=JDBCUtils.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT(1) FROM information_schema.tables WHERE table_name = '"+tableName+"';");
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        int flag=resultSet.getInt(1);
        JDBCUtils.release(connection,preparedStatement,resultSet);
        if (flag==1){
            return true;
        }else {
            return false;
        }
    }
}
