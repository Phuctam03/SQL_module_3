package mvc.module3_accountname.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static String jdbcURL =
            "jdbc:mysql://localhost:3306/furama?useSSL=false";
    private static String username = "tam";
    private static String password = "123456";
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL,
                username, password);
//            System.out.println("ok");
        return connection;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println(DatabaseConnection.getConnection());
    }
}
