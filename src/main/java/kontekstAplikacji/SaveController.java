package kontekstAplikacji;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/save")
public class SaveController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Note note = createNote(request);
        saveNote(note,request);
        String noteUrl = NoteUtils.buildNoteUrl(note);
        request.setAttribute("noteUrl",noteUrl);
        request.getRequestDispatcher("confirmation.jsp").forward(request,response);

    }

    private void saveNote(Note note, HttpServletRequest request) {
        //Obiekt ten przekazujemy do metody saveNote(), gdzie w zależności od tego type priv albo pub
        if (note.getType().equals(Note.TYPE_PRIVATE)){
            request.getSession().setAttribute(note.getId(),note.getContent());//zapisujemy ją jako atrybut sesji
        }else if (note.getType().equals(Note.TYPE_PUBLIC)){
            ServletContext servletContext = getServletContext();
            servletContext.setAttribute(note.getId(),note.getContent());//albo kontekstu aplikacji.
        }
    }


    private Note createNote(HttpServletRequest request) { //tworzenie notatki czyli pobieramy parametry z notatki.jsp
        String noteId = request.getParameter("noteId");
        String noteContent = request.getParameter("noteContent");
        String noteType = request.getParameter("noteType");

        return new Note(noteId,noteContent,noteType);
    }

}