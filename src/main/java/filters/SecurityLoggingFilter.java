package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//Mapowanie "/*" ustawione w adnotacji @WebFilter oznacza, że filtr będzie aktywny dla wszystkich adresów URL w tej aplikacji.
//@WebFilter("/*")
public class SecurityLoggingFilter implements Filter {


    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log(request);

    }

    private void log(ServletRequest request) {
        //W filtrze pobieramy adres IP z jakiego dotarło do nas żądanie
        String ip = request.getRemoteAddr();

        //oraz wartość nagłówka user-agent.
      String userAgent =((HttpServletRequest)request).getHeader("user-agent");
//Podobnie jak było z obiektem response, także w tym przypadku konieczne było rzutowanie, ale tym razem na typ HttpServletRequest,
// ponieważ to właśnie w tej klasie zdefiniowana jest metoda getHeader(), która pozwala pobrać wartość nagłówka z żądania HTTP.

      System.out.println(ip + ">>"+userAgent);
    }

}
