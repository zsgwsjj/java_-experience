package sql;

import java.sql.*;

/**
 * @author : jiang
 * @time : 2018/5/21 16:01
 */
public class JDBCUtils {

    private static Connection conn;

    public static void main(String[] args) throws Exception {
        System.out.println(getGeneratedKey());
    }

    private static int getGeneratedKey() throws Exception {
        conn = getMysqlConn();
        String sql = "INSERT INTO jiang.product (amount) VALUES (?);";
        PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, 1);
        statement.executeUpdate();
        ResultSet resultSet = statement.getGeneratedKeys();
        resultSet.next();
        return resultSet.getInt(1);
    }

    private static Connection getMysqlConn() throws Exception {
        if (conn == null) {
             Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "wangjia");
        }
        return conn;
    }
}
