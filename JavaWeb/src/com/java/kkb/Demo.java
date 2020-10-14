package com.java.kkb;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.*;
import javax.servlet.jsp.jstl.sql.Result;
import javax.servlet.jsp.jstl.sql.ResultSupport;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-11 19:44
 * @Modified By:
 */
public class Demo  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        //处理get请求
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
//        super.doPost(req, resp);
        //设置编码格式   必须在接收参数之前设置
        req.setCharacterEncoding("utf-8");
        //1.    加载数据库驱动 (可以省略的.  在JavaEE的web项目中,jar包不可以省略.)
//        Map map = new HashMap();//声明Map

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //2.    通过驱动管理器, 获取JDBC的连接对象
        System.out.println("222222222");
        Connection conn = null;
        try {
          conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //4.    通过SQL执行对象 执行SQL
        String uname = null;
        String password = null;
        //3.    通过连接对象,创建SQL执行对象 (SQL执行环境)

        Statement state = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        try {
            state = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
           rs1 = state.executeQuery("select name from login_user");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理Post请求


        String username = req.getParameter("username");
        String userpass = req.getParameter("userpass");
        System.out.println("username="+username+",password="+userpass);

            while  (true){
                try {
                    if (!rs1.next()) break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    uname = rs1.getString("name");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    System.out.println("r2:"+uname);
                    rs2 = state.executeQuery("select  password from login_user where name ='张三'");
//                    rs2 = state.executeQuery("select  password from login_user where name="+uname);
                    while(rs2.next()){
                        password = rs2.getString("password");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if (username.equals(uname) && userpass.equals(password)){
                    req.getRequestDispatcher("/success.html").forward(req,resp);
                }else{
                    req.getRequestDispatcher("/error.html").forward(req,resp);
                }
            }





    /*
        if ("admin".equals(username)){
            req.getRequestDispatcher("/success.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("/error.html").forward(req,resp);
        }

     */
        //5.    释放连接
        try {
            rs1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("销毁");
    }


    @Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("初始化");
    }
    /*
    public static List createTable() throws Exception {
        //1.    加载数据库驱动 (可以省略的.  在JavaEE的web项目中,jar包不可以省略.)
//        Map map = new HashMap();//声明Map
        List list = new ArrayList();
        System.out.println("111111111");

        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.    通过驱动管理器, 获取JDBC的连接对象
        System.out.println("222222222");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useSSL=false&serverTimezone=UTC", "root", "123456");

        if (conn.isClosed()){
            System.out.println("连接成功");
        }else{
            System.out.println("连接失败");
        }
        //3.    通过连接对象,创建SQL执行对象 (SQL执行环境)
        Statement state = conn.createStatement();
        ResultSet rs = state.executeQuery("select * from login_user");

        list=convertList(rs);  //转换结果
//        Result result= ResultSupport.toResult(rs);

        rs.close();
        state.close();
        conn.close();
        return  list;
    }

    //结果集转换为list集合
    private static List convertList(ResultSet rs) throws Exception {
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        Map rowData = new HashMap();//声明Map
        while (rs.next()) {

            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return  list;
    }

     */
}
