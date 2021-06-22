package ukrywanieZasobów;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/produkty")
public class HomeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> products = List.of("sukienki", "torebki", "spodnie", "buty");
        request.setAttribute("products", products);
        request.getRequestDispatcher("sklep.jsp").forward(request,response);
    }

}