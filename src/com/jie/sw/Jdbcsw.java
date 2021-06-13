package com.jie.sw;

import com.jie.upda.JdbcTool;

import java.sql.*;



public class Jdbcsw {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcTool.getConnection();
            connection.setAutoCommit(false);

            String sql1="UPDATE `account` SET `money` = `money` - 500  WHERE `name` = 'A'";

            statement = connection.prepareStatement(sql1);
            statement.executeUpdate();

            String sql2="UPDATE `account` SET `money` = `money` + 500  WHERE `name` = 'B'";

            statement = connection.prepareStatement(sql2);
            statement.executeUpdate();
            connection.commit();

            System.out.println("执行成功！");

        }catch (SQLException e){

            try {
                connection.rollback();
            }catch (SQLException e1){
                e1.printStackTrace();
            }

            e.printStackTrace();

        }finally {
            JdbcTool.release(connection,statement,resultSet);
        }
    }
}
