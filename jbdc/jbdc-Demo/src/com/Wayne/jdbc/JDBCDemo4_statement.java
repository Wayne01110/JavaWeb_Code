package com.Wayne.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
   JDBC API 详解：Statement
*/
public class JDBCDemo4_statement {

    /**
     * 执行DQL查询语句
     * @throws Exception
     */
    @Test
    public void testResultSet() throws Exception {
        // 1.注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接: 如果连接的是本机mysal并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL
        String sql1 = "update account set money = 3000 where id = 1";

        // 4.获取执行sql对象
        Statement stmt = conn.createStatement();

        // 5.执行sql
        int count = stmt.executeUpdate(sql1);// 执行完DML语句，受影响的行数

        // 6.处理结果
//        System.out.println(count);
        if(count > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }

        // 7.释放资源
        stmt.close();
        conn.close();
    }
}
