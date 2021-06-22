package przekierowaniaIadresy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet(urlPatterns = {"/loginform"})//musze tu cos wpisac inaczej wchodi bezposrednio na logowanie
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("logowanie.jsp").forward(request,response);
    }

}