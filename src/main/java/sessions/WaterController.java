package sessions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/control")
public class WaterController extends HttpServlet {
    private static final int GLASS_OF_WATER = 250;
//sesja zapisuje dane po stronie serwera a ciasteczka uzytkownika
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String option = request.getParameter("option");//pobieramy atrybut option ktory wybralismy
        HttpSession session = request.getSession();//tworzymy obiekt sesji
        if (option.equals("water")){ //jezeli wybrana opcja water zwiekszamy nawodnienie
            increaseWaterLevel(session);
        }else if (option.equals("clear")){ //jezeli opcja clear usuwamy sesje
            session.removeAttribute("water");
        }
        request.getRequestDispatcher("watercontrol.jsp").forward(request,response);
    }


    private void increaseWaterLevel(HttpSession session) {
        Object water = session.getAttribute("water");
        int resultWater;
        if (water==null){ //jezeli woda 0 wtedy woda = szklanka
            resultWater = GLASS_OF_WATER;
        }else {
            resultWater= ((int)water)+GLASS_OF_WATER; //rzutowanie water na int, obecny poziom wody + szklanka
        }
       session.setAttribute("water",resultWater); //zapisujemy sesje pod "water"
     }

}