package logic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Тимур Мухитдинов on 23.02.2015.
 */
public class CalculatorServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
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
                    if (d2==0) sb.append("Вообще на 0 делить нельзя, но мы-то знаем," +
                            " что будет если всё-таки попробовать:<br>");

                    res = d1 / d2;
                    op = " / ";
                    break;
            }
            String output = d1 + op + d2 + " = " + res;
            sb.append("Ваш результат " + output + "<br>");
        } catch (NumberFormatException e){
            sb.append("Неверно введены значения, чтобы получить результат," +
                    "необходимо заполнить данные заново.");
        } catch (NullPointerException e) {
            sb.append("Одно из значений не было введено, чтобы получить результат," +
                    " необходимо заполнить данные заново.");
        }
        req.setAttribute("attribute", sb.toString());
        RequestDispatcher disp = req.getRequestDispatcher("/index.jsp");
        disp.forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
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
                    if (d2==0) sb.append("Вообще на 0 делить нельзя, но мы-то знаем," +
                            " что будет если всё-таки попробовать:<br>");

                    res = d1 / d2;
                    op = " / ";
                    break;
            }
            String output = d1 + op + d2 + " = " + res;
            sb.append("Ваш результат " + output + "<br>");
        } catch (NumberFormatException e){
            sb.append("Неверно введены значения, чтобы получить результат," +
                    "необходимо заполнить данные заново.");
        } catch (NullPointerException e) {
            sb.append("Одно из значений не было введено, чтобы получить результат," +
                    " необходимо заполнить данные заново.");
        }
        req.setAttribute("attribute", sb.toString());
        RequestDispatcher disp = req.getRequestDispatcher("/index.jsp");
        disp.forward(req, resp);
    }
}
