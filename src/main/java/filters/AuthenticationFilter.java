package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/secret")
public class AuthenticationFilter implements Filter {
    private static final String PASS = "h@rdPass";

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String pass = request.getParameter("filterpass");
        if (pass != null && pass.equals(PASS))
            //W metodzie doFilter() pobieramy wartość parametru pass i sprawdzamy, czy jest równa h@rdPass.
            chain.doFilter(request, response);
        //Jeżeli tak, to korzystając z metody chain.doFilter() przekazujemy obiekty request i respone dalej,
            // tzn. do kolejnego filtra, którego mapowanie odpowiada adresowi /secret, albo do serwletu, jeżeli nie ma więcej filtrów
        else
            ((HttpServletResponse)response).sendError(403, "Wrong password");
        //Jeżeli hasło się nie zgadza, to wysyłamy do użytkownika kod odpowiedzi 403 Forbidden (dostęp zabroniony) z komunikatem "Wrong password".
    }
}
// Jedną z rzeczy, która odróżnia metodę doFilter() od metod doGet(), czy doPost() z serwletów jest to,
// że przyjmuje ona parametry typu ServletRequest i ServletResponse. Są to typy nadrzędne dla HttpServletRequest i HttpServletResponse.
// Z tego powodu konieczne jest rzutowanie, ponieważ metoda sendError() zdefiniowana jest w klasie HttpServletResponse, a nie ServletResponse.