<%--
  Created by IntelliJ IDEA.
  User: YNB
  Date: 2020/10/12
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSP test</h1>

request= <%=request.getAttribute("req")%>
session= <%=session.getAttribute("sessionkey")%><br>
application= <%=application.getAttribute("app")%>

</body>
</html>
