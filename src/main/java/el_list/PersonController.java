package el_list;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/elogin")
public class PersonController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        getServletContext().setAttribute("people", new ArrayList<Person>());
        //Zdefiniowałem metodę init(), w której tworzę na poziomie kontekstu aplikacji listę przechowującą obiekty Person.
        // Zrobiłem to w ten sposób, ponieważ metoda init() wywoływana jest tylko raz, przy tworzeniu obiektu serwletu,
        // aby później w metodzie doPost() nie musieć zapisywać ifa, który sprawdzi, czy taki atrybut jest już utworzony,
        // czy nie. W metodzie doPost() odbieramy dane z formularza i dodajemy nowo utworzony obiekt do wspomnianej listy.
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/home.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = Integer.parseInt(request.getParameter("age"));
        Gender gender =Gender.valueOf(request.getParameter("gender"));//przeksztalcamy String na Gender
        Person person = new Person(firstName, lastName, age, gender);
        List<Person> peopleList = (List<Person>) getServletContext().getAttribute("people");//String do listy
        peopleList.add(person);
        request.getRequestDispatcher("home.jsp").forward(request,response);
    }
}