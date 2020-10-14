package com.java.jdbc;


import java.sql.*;

public class Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createTable();
    }

    public static void createTable() throws ClassNotFoundException, SQLException {
        String uname1 = "张三";
        String upass = "123456";

        String sql1 = "select * from login where  uname = '"+uname1+"'";
//        String sql1 = "select Money from users where username='+uname'";
        //1.    加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.  通过驱动连接数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testuser", "root", "");

        //3.    通过连接对象,创建SQL执行对象 (SQL执行环境)
        Statement state = conn.createStatement();
        //        //4.    通过SQL执行对象 执行SQL

        ResultSet rs = state.executeQuery(sql1);
        while (rs.next()) {
//            int id = rs.getInt("id");
            String name = rs.getString("uname");
            String up = rs.getString("upword");
            System.out.println("name:" + name + "password:" + up);
            if (uname1.equals(name) && upass.equals(up)) {
                System.out.println("成功");
            } else {
                System.out.println("失败");
            }
//            System.out.println("id="+id+"\tnickname="+nickname);
        }


        //        //5.    释放连接
        state.close();
        conn.close();

    }
}
