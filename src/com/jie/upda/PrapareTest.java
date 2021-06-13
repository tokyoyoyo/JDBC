package com.jie.upda;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PrapareTest {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcTool.getConnection();
            String sql = "DELETE FROM `users` WHERE id = ?";
            statement = connection.prepareStatement(sql);   //预编译sql语句，但是不执行

            //手动赋值
            statement.setInt(1,5);

            int i = statement.executeUpdate();

            if(i > 0){
                System.out.println("删除成功！！！");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            JdbcTool.release(connection,statement,resultSet);
        }
    }
}
