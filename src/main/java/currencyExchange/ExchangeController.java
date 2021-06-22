package currencyExchange;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;

@WebServlet("/convert")
public class ExchangeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


   //W zależności od tego, czy parametry są poprawne, czy nie, to albo przekażemy żądanie do strony result.jsp w metodzie successDispatch(),
        // albo do strony error.jsp w metodzie errorDispatch().
     if (validatateParameteres(request)){
         successDispatch(request,response);
     }else {
         errorDisatch(request,response);
     }
    }

    private void errorDisatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/error.jsp").forward(request,response);
    }


    private boolean validatateParameteres(HttpServletRequest request) {// Zwraca true jeżeli wszystkie parametry są prawidłowe, lub false w innym przypadku.
        String exchangeParam = request.getParameter("exchange");
        if (exchangeParam==null|| exchangeParam.equals("")){
            request.setAttribute("message","Typ wymiany nie został określony");
            return false;
        }else {
            ExchangeType[] exchangeTypes = ExchangeType.values();
            boolean invalidEchangeType = Arrays.stream(exchangeTypes)
                    .map(Enum::toString)
                    .noneMatch(exchangeType -> exchangeType.equals(exchangeParam));
        if (invalidEchangeType){
            request.setAttribute("message", "Nieznany typ wymiany: "+exchangeParam);
            return false;
        }
        }
        String value = request.getParameter("value");
        if (value==null||value.equals("")){
            request.setAttribute("message", "Kwota nie została określona");
            return false;
        }else if(!value.matches("-?\\d+(\\.\\d+)?")) {
            request.setAttribute("message", "Nieprawidłowy numerek");
return false;
        }
        return true;
    }

    private void successDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Na początku pobieramy dane z formularza.
        String valueString = request.getParameter("value");
        BigDecimal value = new BigDecimal(valueString);
        String exchangeString = request.getParameter("exchange");
        ExchangeType exchangeType = ExchangeType.valueOf(exchangeString);
        //Parametr value zamieniamy na obiekt typu BigDecimal, a przelicznik na wartość typu ExchangeType.
        ExchangeResult exchangeResult = ExchangeCalculator.exchange(value, exchangeType);
        //Na ich podstawie wykonujemy obliczenia korzystając z kalkulatora, czyli metody ExchangeCalculator.exchange().
        request.setAttribute("result",exchangeResult);
        //zapisujemy wynik w atrybucie czyli obiekcie żądania
        request.getRequestDispatcher("/result.jsp").forward(request, response);
        //przekazanie żądania do strony JSP
        //Na obiekcie RequestDispatcher wywołujemy metodę forward() z argumentami request i response,
        // dzięki czemu sterowanie aplikacji przenosi się do strony result.jsp, którą zdefiniujemy za moment.
    }

}