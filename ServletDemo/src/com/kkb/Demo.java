package com.kkb;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author: YNB
 * @Description:
 * @Date Created in 2020-10-11 14:06
 * @Modified By:
 */
public class Demo implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化参数的方法");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("执行业务逻辑的方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁Servlet");
    }
}
