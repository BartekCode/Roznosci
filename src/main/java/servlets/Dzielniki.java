package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/dzielniki")
public class Dzielniki extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int n = Integer.parseInt(request.getParameter("n"));
        Divide divide = new Divide();
        PrintWriter writer = response.getWriter();
        ArrayList<Integer> dzielniki = divide.dzielniki(n);
        writer.println("<html>");
        writer.println("<head></head>");
        writer.println("<body>");
        writer.println("<h1>Podzielnik liczby "+n+" </h1>");
        writer.println("<ul>");
        for (Integer liczba:dzielniki) {

            writer.printf("<li>%s</li>",liczba);


        }
        writer.println("</ul>");
        writer.println("</body>");
        writer.println("</html>");

    }

}