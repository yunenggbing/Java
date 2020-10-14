package com.java.jdbc;


import java.sql.*;
import java.util.*;

public class Demo2 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        HashMap<String, Character> hashMap = new HashMap<String, Character>();
        List list = new ArrayList();
        list = createTable();
        System.out.println(list.toString());
//        list.add("name=张三,password=123456");
//        list.add("name=李四,password=123456");

        for (int i=0;i<list.size();i++){
            hashMap = (HashMap<String, Character>) list.get(i);
        }
/*
        HashMap<String, Character> hashMap=new HashMap<String, Character>();
                 //添加元素
                 hashMap.put("王祖贤", '女');
                 hashMap.put("林俊杰", '男');
                 hashMap.put("林青霞", '女');
        System.out.println(hashMap.toString());

 */
        Set<String> set=hashMap.keySet();
               for (String string : set) {
                        System.out.println(string+" "+hashMap.get(string));
                    }


    }

    public static List createTable() throws ClassNotFoundException, SQLException {
        List list = new ArrayList();
        String uname1 = "张三";
        String upass = "123456";

//        String sql1 = "select * from login where  uname = '"+uname1+"'";
        String sql1 = "select  * from  login";
        //1.    加载数据库驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2.  通过驱动连接数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testuser", "root", "");

        //3.    通过连接对象,创建SQL执行对象 (SQL执行环境)
        Statement state = conn.createStatement();
        //        //4.    通过SQL执行对象 执行SQL

        ResultSet rs = state.executeQuery(sql1);
        list = convertList(rs);


        //        //5.    释放连接
        state.close();
        conn.close();
        return list;

    }

    private static List convertList(ResultSet rs) throws SQLException {
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return list;
    }
}
