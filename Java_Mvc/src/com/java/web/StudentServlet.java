package com.java.web;

import com.java.bean.Student;
import com.java.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-14 21:28
 * @Modified By:
 */
//@WebServlet(value = "/getallstudent")
@WebServlet(value = "/getallstudent")
public class StudentServlet  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接受参数    指的是接收浏览器的数据
        //2.读取service方法
        StudentServiceImpl studentService = new StudentServiceImpl();
        List<Student> student = studentService.getAll();

        //3.跳转页面
        req.setAttribute("students",student);
//        req.getRequestDispatcher("show.jsp").forward(req,resp);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
}
