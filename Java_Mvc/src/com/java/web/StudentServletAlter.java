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
 * @Date Created in 2020-10-15 22:02
 * @Modified By:
 */
@WebServlet(value = "/alterData")
public class StudentServletAlter extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Alter  Data");
    }
}
