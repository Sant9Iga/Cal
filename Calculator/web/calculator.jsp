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
        try{
            String s1 = request.getParameter("n1");
            String s2 = request.getParameter("n2");
            if (s1.length()==0 || s2.length()==0) throw new NullPointerException();
            s1 = s1.replace(",",".");
            s2 = s2.replace(",",".");
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            double res = 0;
            String op = "";
            switch (Integer.parseInt(request.getParameter("operation"))){
                case 1:
                    res = d1 + d2;
                    op = " + ";
                    break;
                case 2:
                    res = d1 - d2;
                    op = " - ";
                    break;
                case 3:
                    res = d1 * d2;
                    op = " * ";
                    break;
                case 4:
                    if (d2==0)
    %>
    Вообще на 0 делить нельзя, но мы-то знаем, что будет если всё-таки попробовать:<br>
    <%
                    res = d1 / d2;
                    op = " / ";
                    break;
            }
            String output = d1 + op + d2 + " = " + res;
    %>
    Ваш результат <%= output%><br>
    Здорово, правда?! :)<br>
    <a href="/index.jsp">Может попробовать снова, а?</a>
    <%
        } catch (NumberFormatException e){
    %>
    Неверно введены значения, чтобы получить результат, необходимо <a href="/index.jsp">вернуться</a> и заполнить данные заново.
    <%
        } catch (NullPointerException e){
    %>
    Одно из значений не было введено, чтобы получить результат, необходимо <a href="/index.jsp">вернуться</a> и заполнить данные заново.
    <%
        }
    %>
</h2>
</body>
</html>
