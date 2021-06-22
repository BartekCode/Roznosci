package loteria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/lottery")
public class LotteryController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> userNumbers = getNumbers(request);//pobieramy liczby które podał użytkownik dzieki metodzie w postaci listy Integer
        List<Integer> lotteryNumbers = Loteria.lotteryNumbers();//pobieramy 6 liczb wylsoowanych w loterii
        ArrayList<Integer> winNumbers = Loteria.winNumbers(userNumbers, lotteryNumbers); //sprawdzamy wygrane liczby
        WynikiLoterii wynikiLoterii = new WynikiLoterii(userNumbers, lotteryNumbers, winNumbers);
        //tworzymy obiekt wynikiLoterii dzieki konstruktorowi podajmy usernumbers lotterynumber i winNumbers ktore bnedzie mozna pozniej pobrac przez gettery
        request.setAttribute("lotteryResult", wynikiLoterii);//przekazujemy wyniki loterii jako lotteryResult obiekt wyniki loterii czyli bedzie posiadal 3 atrybuty
        request.getRequestDispatcher("wynikLosowania.jsp").forward(request,response);//dalej przechodzmy do wynikLosowania.jsp
    }

    private List<Integer> getNumbers(HttpServletRequest request) {
        String[] numberParam = request.getParameterValues("numbers");////pobieramy liczby które podał użytkownik
        // pobieramy listę Stringów wszystkie inputy mialy nazwę numbers
        return Arrays.stream(numberParam)//tablica na strumien
                .map(Integer::valueOf) //mapujemy na Integera
                .collect(Collectors.toList()); //i kolekcje na listę
    }
}