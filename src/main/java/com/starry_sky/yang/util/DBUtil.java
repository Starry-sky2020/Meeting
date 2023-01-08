package com.starry_sky.yang.util;

import java.sql.*;

public class DBUtil {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3336/meeting";
    private static String user = "root";
    private static String password = "20222022";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url,user,password);
        return connection;
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
        if (resultSet != null){
            resultSet.close();
        }

        if (statement != null){
            statement.close();
        }

        if (connection != null){
            connection.close();
        }
    }
}