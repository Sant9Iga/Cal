package logic;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Тимур Мухитдинов on 23.02.2015.
 */
public class CalculatorServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();
        pw.println("<html>\n" +
                "<head>\n" +
                "    <title>Ваш ответ</title>\n" +
                "    <link rel=\"stylesheet\" href=\"forIndex.css\" type=\"text/css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>");
        try{
            String s1 = req.getParameter("n1");
            String s2 = req.getParameter("n2");
            if (s1.length()==0 || s2.length()==0) throw new NullPointerException();
            s1 = s1.replace(",",".");
            s2 = s2.replace(",",".");
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            double res = 0;
            String op = "";
            switch (Integer.parseInt(req.getParameter("operation"))){
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
                    if (d2==0) pw.println("Вообще на 0 делить нельзя, но мы-то знаем," +
                            " что будет если всё-таки попробовать:<br>");

                    res = d1 / d2;
                    op = " / ";
                    break;
            }
            String output = d1 + op + d2 + " = " + res;
            pw.println("Ваш результат " + output + "<br>");
            pw.println("Здорово, правда?! :)<br>");
            pw.println("<a href=\"/index.jsp\">Может попробовать снова, а?</a>");
        } catch (NumberFormatException e){
            pw.println("Неверно введены значения, чтобы получить результат," +
                    "необходимо <a href=\"/index.jsp\">вернуться</a> и заполнить данные заново.");
        } catch (NullPointerException e) {
            pw.println("Одно из значений не было введено, чтобы получить результат," +
                    " необходимо <a href=\"/index.jsp\">вернуться</a> и заполнить данные заново.");
        }
        pw.println("</h2>\n" +
                "</body>\n" +
                "</html>");
    }
}
