package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/counter")
public class CounterController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Optional<Cookie> visitsCookie = getCookieByName(request, "visits");
        Integer numberOfVisits = visitsCookie
                // jeżeli ciasteczko o nazwie visits zostało znalezione, to pobieramy jego wartość i zamieniamy ją na obiekt Integer
                .map(Cookie::getValue)
                .map(Integer::valueOf)
                .orElse(0);//eżeli takie ciasteczko nie istniało (Optional jest pusty), to ustawiamy numberOfVisits na 0

         numberOfVisits++;//zwiekszamy liczbe visyt o 1
        request.setAttribute("numberOfVisits", numberOfVisits);//zapisujemy atrybut
        Cookie cookie = new Cookie("visits", Integer.toString(numberOfVisits));
        //tworzony jest obiekt Cookie, którego nazwę ustawiamy na visits, a wartość na wcześniej zdefiniowaną zmienną, ale zamienioną na stringa.
        cookie.setMaxAge(30*24*60*60); //ustawiamy czas zycia ciasteczka
        
        //Aby ciasteczko trafiło do użytkownika musimy je dołączyć do obiektu odpowiedzi. Robimy to wywołując metodę addCookie() na obiekcie response.
        response.addCookie(cookie);
       request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    private Optional<Cookie> getCookieByName(HttpServletRequest request, String cookieName) {//metoda do pobrania ciasteczka po nazwie
        Cookie[] cookies = request.getCookies(); //pobieramy ciasteczka do tablicy
        if (cookies==null){
            return Optional.empty();
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName))//szukamy ciasteczko o podanej nazwie
                return Optional.of(cookie);

        }
        return Optional.empty();
    }

}