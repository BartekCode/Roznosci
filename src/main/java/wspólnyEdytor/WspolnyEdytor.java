package wspólnyEdytor;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/edytor")
public class WspolnyEdytor extends HttpServlet {
//najpierw pobieramy to co jest zapisane w text area przy uzyciu doGet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Object text = servletContext.getAttribute("text");
        request.setAttribute("text", text != null ? text : "");//jezeli text = null to ustawiamy napis ""
        request.getRequestDispatcher("wspolnyedytor.jsp").forward(request, response);

    }

//pozniej zapisujemy to przy uzyciu Context by inni mogli to widziec
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");//pobieramy parametr zapisujemy do text
        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("text", text); //zapisujemy text jako Context
        request.setAttribute("text", text!=null ? text:""); //jezeli nie null to zapisujemy w innym przepadku ""
        request.getRequestDispatcher("wspolnyedytor.jsp").forward(request,response);//i przkazujemy do pliku jsp

    }
}