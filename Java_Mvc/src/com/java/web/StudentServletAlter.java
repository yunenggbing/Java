package com.java.web;

import com.java.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-15 22:02
 * @Modified By:
 */
@WebServlet(value = "/alterData")
public class StudentServletAlter extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Alter  Data");
        System.out.println("Delete Data");
        req.setCharacterEncoding("utf-8");
        System.out.println("AddData");
        //1.接受参数    指的是接收浏览器的数据
        String stuname = req.getParameter("uname");
        String stunum = req.getParameter("stunum");
        String stuage = req.getParameter("stuage");
        String gradeid = req.getParameter("gradeid");
        System.out.println("姓名："+stuname);
        System.out.println("学号："+stunum);
        System.out.println("年龄："+stuage);
        System.out.println("年级："+gradeid);

        //2.读取service方法

        //执行Dao层
        StudentServiceImpl stuiml = new StudentServiceImpl();
        int flag = 0;
        try {
            flag = stuiml.altStudent(stuname,stunum,stuage,gradeid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

//        StudentServiceImpl studentService = new StudentServiceImpl();
//        List<Student> student = null;
//        try {
//            student = studentService.addStudent();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        //3.跳转页面
//        req.setAttribute("students",student);
        if (flag == 0 ){
            req.getRequestDispatcher("failure.jsp").forward(req,resp);
        }else  {
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }

    }
}
