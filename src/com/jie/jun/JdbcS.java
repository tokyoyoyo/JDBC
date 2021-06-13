package com.jie.jun;

import java.sql.*;

public class JdbcS {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1、加载驱动,固定写法
        //  DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

        //2、用户信息和url
        //  useUnicode=true&characterEncoding=utf8&useSSL=true
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&characterEncoding=utf8&useSSL=true";
        String username = "root";
        String password = "123456";

        //3、连接数据库对象成功，connection代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);


        //4、执行SQL的对象，
        Statement statement = connection.createStatement();

        //5、执行器去执行SQL，查看返回结果
        String sql = "SELECT * FROM `users`";

        ResultSet resultSet = statement.executeQuery(sql);  //返回的结果集,封装了全部的查询结果



        while (resultSet.next()){
            System.out.println("id = " +resultSet.getObject("id") );
            System.out.println("name = " +resultSet.getObject("name") );
            System.out.println("pass word = " +resultSet.getObject("pwd") );
            System.out.println("Email = " +resultSet.getObject("email") );
            System.out.println("birthday = " +resultSet.getObject("birthday") );
            System.out.println("======================================================");
        }

        //6、释放连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
