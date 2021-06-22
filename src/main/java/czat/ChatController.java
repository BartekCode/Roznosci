package czat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/chat")
public class ChatController extends HttpServlet {


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("chat.jsp").forward(req,resp); //by bez zadnego wysyłania danych mozna bylo wejsc na chat
    }

    @Override
    public void init() throws ServletException {
       getServletContext().setAttribute("users", new ArrayList<User>()); //na samym początku przy tworzeniu obiektu serwletu tworzymy listę
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String userName = request.getParameter("username");
       String text = request.getParameter("text");
       User user = new User(userName, text); //tworzymy obiekt User czyli User + jego text
       List<User> usersMess = (List<User>) getServletContext().getAttribute("users"); //pobieramy naszą listę utworzoną w init jako kontekst aplikacji
       usersMess.add(user);
       request.getRequestDispatcher("chat.jsp").forward(request,response);

    }

}