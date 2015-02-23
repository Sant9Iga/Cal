<%--
  Created by IntelliJ IDEA.
  User: Тимур Мухитдинов
  Date: 23.02.2015
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ваш ответ</title>
    <link rel="stylesheet" href="forIndex.css" type="text/css">
</head>
<body>
<h2>
    <%
        String s = (String)request.getAttribute("attribute");
    %>
    <%= s%><br>
</h2>
</body>
</html>
