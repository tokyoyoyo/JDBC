package com.jie.upda;

import java.io.InputStream;
import java.util.Properties;
import java.sql.*;

public class JdbcTool {
    private static String driver = null;
    private static String url = null;
    private static String userName = null;
    private static String passWord = null;
    private static String sql = null;
    static{
        try{
            InputStream inputStream = JdbcTool.class.getClassLoader().getResourceAsStream("db_jdbcstudy.properties");

            Properties properties = new Properties();
            properties.load(inputStream);

            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            passWord = properties.getProperty("passWord");
            sql =properties.getProperty("sql");

            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,userName,passWord);
    }

    public static String getSql(){
        return sql;
    }
    //释放连接资源
    public static void release(Connection connection,Statement statement, ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(statement != null){
            try {
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }
}
