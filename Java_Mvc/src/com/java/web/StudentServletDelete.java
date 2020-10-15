package com.java.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-15 22:07
 * @Modified By:
 */
@WebServlet(value = "/deleteData")
public class StudentServletDelete  extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Delete Data");
    }
}
