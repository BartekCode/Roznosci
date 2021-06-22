package kontekstAplikacji;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = {"/private", "/public"})
public class NoteController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    findNote(request).ifPresent(note->request.setAttribute("note",note));//przekazujemy atrybut
        request.getRequestDispatcher("note.jsp").forward(request,response);//i leci dalej
    }

    private Optional<String> findNote(HttpServletRequest request) { //szuakmy notatki o wskazanym identyfikatocze
        String servletPath = request.getServletPath();//pobieramy wartosc zwaracna przez metode request.getServletPath
        //W wyniku otrzymamy ścieżkę pod jakim odwołano się do serwletu.
        // Przykładowo jeżeli ktoś wywołał metodę doGet() przez adres localhost:8080/aplikacja/private?id=abc to metoda getServletPath() zwróci wartość /private.
        String noteId = request.getParameter("id");//Dalej pobieramy parametr id, czyli identyfikator notatki. w naszym przyklazie bylo by to abc
        String note = null;
        if (servletPath.contains(NoteUtils.PRIVATE_PATH)){
            note = (String) request.getSession().getAttribute(noteId);
        }else if (servletPath.contains((NoteUtils.PUBLIC_PATH))){
            note = (String) getServletContext().getAttribute(noteId);
        }
       return Optional.ofNullable(note);//zwaracamy Optional ktory moze byc nullem
     }
//W przypadku, gdy żądanie przyszło pod adres /private to wiemy, że notatki należy szukać w sesji,
// a gdy żądanie trafiło pod adres /public, to szukamy atrybutu w kontekście aplikacji
}