package przekierowaniaIadresy;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("admin".equals(username)&&"admin".equals(password)){//sprawdzamy czy to admin
            request.getSession().setAttribute("username", username); //zapisujemy w sesji username inaczej utracimy go przy przekierowaniu a tak bedzie zpaamiaetany w sesji
          //  request.getRequestDispatcher("adminPage.jsp").forward(request,response);
            response.sendRedirect("admin"); //przekierowanie dzieki sendRedirect
            //W przypadku stron jsp nigdy nie powinniśmy kierować żądań bezpośrednio do nich, tylko powinny one być powiązane z jakimś kontrolerem.
            //kontroller np wysle odpowiedz na adminPage.jsp

        }else {
           // request.getRequestDispatcher("error.html").forward(request,response);
            response.sendRedirect("error.jsp");
            //Po wprowadzeniu tej zmiany, poprawnie będzie działała jedynie strona błędu.
            // W jej przypadku możemy wykonać przekierowanie bezpośrednio do strony html, ponieważ jest to zwykły plik statyczny.
            //w powyzszym przepadku chcemu uzyskac przekierowanie inaczej po odswiezeniu strony bedzie bład,
            // bo metoda post nie sluzy do bezporsredniego wydrku strony error bnadz admin

        }
    }//Po odebraniu parametrów sprawdzamy, czy nazwa użytkownika i hasło to fraza admin.
    // W zależności od tego, czy dane są poprawne, czy nie, przekazujemy żądanie do strony adminPage.jsp, albo error.jsp.
    // Nazwę użytkownika zapisuję jako atrybut żądania, aby wyświetlić ją na stronie adminPage.jsp jako powitanie.

}