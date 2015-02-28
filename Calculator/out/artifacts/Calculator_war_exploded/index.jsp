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
      <script src="http://code.jquery.com/jquery-latest.min.js"></script>
      <script>
          $(document).ready(function() {                        // When the HTML DOM is ready loading, then execute the following function...
              $('#somebutton').click(function() {               // Locate HTML DOM element with ID "somebutton" and assign the following function to its "click" event...
                  $.get('calc', function(responseText) { // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                      $('#somediv').text(responseText);         // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
                  });
              });
          });
      </script>
  </head>
  <body>
  <h1>Простой калькулятор</h1>
  <p>Введите числа в поля и выберите операци. Чтобы получить ответ, нажмите на "Рассчитать"</p>
  <br>
  <form action="/calculator" method="post">
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
              <td><input id="somebutton" type="submit" value="Рассчитать"></td>
              <td></td>
          </tr>
      </table>
  </form>
  <div id="somediv"></div>
  </body>
</html>
