package com.Wayne.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
   JDBC API 详解：Connection
*/
public class JDBCDemo3_Connection {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        // 2.获取连接: 如果连接的是本机mysal并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";

        // 4.获取执行sql对象
        Statement stmt = conn.createStatement();

        try {
            // 开启事务
            conn.setAutoCommit(false);
            // 5.执行sql
            int count1 = stmt.executeUpdate(sql1);
            // 6.处理结果
            System.out.println(count1);

            // 5.执行sql
            int count2 = stmt.executeUpdate(sql2);
            // 6.处理结果
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            // 回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        // 7.释放资源
        stmt.close();
        conn.close();
    }
}
