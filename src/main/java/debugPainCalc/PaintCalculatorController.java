package debugPainCalc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/paintcalculate")
public class PaintCalculatorController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     Room room = getRoom(request);
        PaintDetails painDetails = getPainDetails(request);
        int paintAmount = PaintCalculator.calculatePaintAmount(room, painDetails);
        request.setAttribute("paintArea", room.getPaintArea() / PaintCalculator.SQM_TO_SQMCM);
        request.setAttribute("paintAmount", paintAmount);
        request.getRequestDispatcher("kalkfarb.jsp").forward(request,response);
    }

    private Room getRoom(HttpServletRequest request) {
        int roomLength = Integer.parseInt(request.getParameter("roomLength"));
        int roomWidth = Integer.parseInt(request.getParameter("roomWidth"));
        int roomHeight = Integer.parseInt(request.getParameter("roomHeight"));
        ConstructionElement[] constructionElements = getConstructionElements(request);
        return new Room(roomWidth,roomHeight,roomLength,constructionElements);
    }

    private ConstructionElement[] getConstructionElements(HttpServletRequest request) {
        int constructionElementsNo = Integer.parseInt(request.getParameter("constructionElements"));
        ConstructionElement[] elements = new ConstructionElement[constructionElementsNo];
        String[] widths = request.getParameterValues("width");//pobieramy tablice
        String[] heights = request.getParameterValues("height");
        for (int i = 0; i < constructionElementsNo; i++) {
            int width = Integer.parseInt((widths[i]));
            int height = Integer.parseInt((heights[i]));
            elements[i] = new ConstructionElement(width, height);
        }
return elements;

    }
    private PaintDetails getPainDetails(HttpServletRequest request){
        int paintCoverage = Integer.parseInt(request.getParameter("paintCoverage"));//po prostu pobieramy parametry ktore sa ofc Stringami i zmamieniamy je na int
        int paintCoats = Integer.parseInt(request.getParameter("paintCoats"));
        return new PaintDetails(paintCoverage, paintCoats);
    }
}
//Klasa kontrolera odpowiada za odebranie parametr??w z ????dania i utworzenie na ich podstawie wszystkich niezb??dnych
// obiekt??w modelu (Room, PaintDetails). Korzystaj??c z klasy kalkulatora obliczana jest potrzebna ilo???? farby,
// ustawiane s?? atrybuty i ????danie przekazywane jest do strony JSP, na kt??rej wy??wietlimy wyniki.