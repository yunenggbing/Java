<%--
  Created by IntelliJ IDEA.
  User: YNB
  Date: 2020/10/12
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%! String a= "测试"; %>
  <%! public  String getA(){return  a;}%>
  a的值是:<%=a+"abc"%>

  <% request.setAttribute("req","request的值");
   session.setAttribute("sessionkey","session的值");
    application.setAttribute("app","application的值");
    pageContext.setAttribute("pa","pageContext的值");
  %>
<hr>
  小脚本方式获取：<br>
  request= <%=request.getAttribute("req")%>
  session= <%=session.getAttribute("sessionkey")%><br>
  application= <%=application.getAttribute("app")%><br>
  pageContext= <%=pageContext.getAttribute("pa")%>
  <% out.print("<script>alert('aaaa')</script>");%>
  url= <%= config.getServletContext().getRealPath("/image")%>
<hr>
  <h1>EL表达式</h1>
  request= ${req}<br>
  session= ${sessionkey}<br>
  application= ${app}<br>
  pageContext= ${pa}
  </body>
</html>
