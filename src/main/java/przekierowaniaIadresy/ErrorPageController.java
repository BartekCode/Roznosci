package przekierowaniaIadresy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/error")
public class ErrorPageController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     request.getRequestDispatcher("error.jsp").forward(request,response);
    }
//W przypadku metody getRequestDispatcher() nie musimy dodawać na początku adresu dopisku request.getContextPath().
// Jeżeli podana w niej ścieżka rozpoczyna się od "/", to adres jest traktowany jako relatywny względem ścieżki aplikacji, a nie kontenera serwletów.
}