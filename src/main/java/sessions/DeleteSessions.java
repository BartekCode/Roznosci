package sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/deletesessions")
public class DeleteSessions extends HttpServlet {
//W celu przetestowania funkcjonalności usuwania sesji dodajmy nowy serwlet, który będzie obsługiwał żądania pod "tajnym" adresem /deletesession.
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session!=null){//sesja jest usuwana tylko wtedy, gdy faktycznie istnieje. Jeżeli jej nie ma, to if nie zostanie wykonany.
            session.invalidate();//invalidate medota do usuwania calej sesji
            request.getRequestDispatcher("/watercontrol.jsp").forward(request,response);//gdzie dalej przechodzimy
        }
    }

}