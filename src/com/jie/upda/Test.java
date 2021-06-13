package com.jie.upda;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try{
            connection=JdbcTool.getConnection();    //获取连接
            statement = connection.createStatement();   //获取SQL执行对象

            int i = statement.executeUpdate(JdbcTool.getSql());
            if(i > 0){
                System.out.println("执行成功！！！");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcTool.release(connection,statement,resultSet);
        }
    }
}
