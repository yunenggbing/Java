<%--
  Created by IntelliJ IDEA.
  User: YNB
  Date: 2020/10/14
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    &lt;%&ndash;加载jstl包&ndash;%&gt;--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>show.jsp</h1>

<table border="1" cellspacing="0" width="800px">

    <tr>
        <td>学生编号</td>
        <td>学生姓名</td>
        <td>学生年龄</td>
        <td>学生年级</td>
    </tr>
<c:forEach items="${students}" var="stu">
    <tr>
        <td>${stu.stunum}</td>
        <td>${stu.stuname}</td>
        <td>${stu.stuage}</td>
        <td>${stu.gradeid}</td>
    </tr>

</c:forEach>
</table>
</body>
</html>
