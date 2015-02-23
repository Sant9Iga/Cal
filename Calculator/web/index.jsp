<%--
  Created by IntelliJ IDEA.
  User: Тимур Мухитдинов
  Date: 23.02.2015
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Ввод данных</title>
    <link rel="stylesheet" href="forIndex.css" type="text/css">
  </head>
  <body>
  <h1>Простой калькулятор</h1>
  <p>Введите числа в поля и выберите операци. Чтобы получить ответ, нажмите на "Рассчитать"</p>
  <br>
  <form action="/calculator" method="get">
      <table>
          <tr>
              <td><label for="n1-field">Введите первое число</label></td>
              <td>Выберите операцию</td>
              <td><label for="n2-field">Введите второе число</label></td>
          </tr>
          <tr></tr>
          <tr>
              <td><input type="text" name="n1" id="n1-field"></td>
              <td><select name="operation">
                  <option value="1">+</option>
                  <option value="2">-</option>
                  <option value="3">*</option>
                  <option value="4">/</option>
              </select></td>
              <td><input type="text" name="n2" id="n2-field"></td>
          </tr>
          <tr></tr>
          <tr>
              <td></td>
              <td><input type="submit" value="Рассчитать"></td>
              <td></td>
          </tr>
      </table>
  </form>
  <%
      String s = (String)request.getAttribute("attribute");
  %>
  <%= s!=null ? s : ""%><br>
  </body>
</html>
