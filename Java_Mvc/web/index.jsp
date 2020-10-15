<%--
  Created by IntelliJ IDEA.
  User: YNB
  Date: 2020/10/14
  Time: 21:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%--  //查询所有--%>
<h1><a href="getallstudent">getallstudent</a></h1>
<%--  //增加数据--%>
<form action="${pageContext.request.contextPath}/myform" method="POST">
    学生姓名：<input type="text" name="uname"/> <br/><br/>
    学生编号：<input type="text" name="stunum"/> <br/><br/>
    学生年龄：<input type="text" name="stuage"/> <br/><br/>
    学生年级：<input type="text" name="gradeid"/> <br/><br/>
    <%--
    formaction="/addData"
    formaction="/alterData"
    formaction="/deleteData"
    formaction="/allData"
    formaction="${pageContext.request.contextPath}/addData"
    --%>
    <button id="add" formaction="${pageContext.request.contextPath}/addData">增加</button>&nbsp;&nbsp;
    <button id="alter" formaction="${pageContext.request.contextPath}/alterData">修改</button>&nbsp;&nbsp;
    <button id="delete" formaction="${pageContext.request.contextPath}/deleteData">删除</button>&nbsp;&nbsp;
    <button id="all">查询所有</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</form>
</body>
<%--  <script type="text/javascript">--%>
<%--    function addData() {--%>
<%--      document.getElementById("add").value="add";--%>
<%--      document.forms[0].submit();--%>
<%--      // console.log(document.getElementById("add"))--%>
<%--    }--%>
<%--    function alt() {--%>
<%--      document.getElementById("alter").value="alter";--%>
<%--      document.forms[0].submit();--%>
<%--      // console.log(document.getElementById("alter"))--%>
<%--    }--%>
<%--    function del() {--%>
<%--      document.getElementById("delete").value="delete";--%>
<%--      document.forms[0].submit();--%>
<%--      // console.log(document.getElementById("delete"))--%>
<%--    }--%>
<%--    function allData() {--%>
<%--      document.getElementById("all").value="all";--%>
<%--      document.forms[0].submit();--%>
<%--      // alert("alter")--%>
<%--      // console.log(document.getElementById("all"))--%>

<%--    }--%>
<%--  </script>--%>
</html>
