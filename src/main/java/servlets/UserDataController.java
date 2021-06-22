package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userData")
public class UserDataController extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   User user = CreateUserFromRequest(request);
        //request.setAttribute("user", user); //zapisujemy nasz atrybut user do "user"
        //  sendResponse(user, response);
        request.getRequestDispatcher("zarejestrowanyUzytkownik.jsp").forward(request,response);


    }



    private User CreateUserFromRequest(HttpServletRequest request) {
        User user = new User();
        user.setUserName(request.getParameter("username"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));
        user.setHobby(request.getParameterValues("hobby"));
        request.setAttribute("user", user);//ustawiamy atrybut user naszym stworzonym obiektem user, pozniej z niego bedzie mozna sciagac dane

        return user;
    }
    private void sendResponse(User user, HttpServletResponse response) throws IOException {
        UserDataController userDataController = new UserDataController();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.print("<h2>Dane odebrano pomyślnie</h2>");
        writer.print("<div>");
        writer.println("Nazwa użytkownika: "+user.getUserName() + "<br>");
        String password = user.getPassword();
        if (userDataController.passwordLength(password)==true&&userDataController.bigLetter(password)==true&&userDataController.hasDigit(password)==true) {
            writer.println("Hasło spełnia wszystkie kryteria bezpieczeństwa");
            writer.println("Hasło : " + password + "<br>");
        }else {
            writer.println("<p>Hasło nie spełnia wymogów</p>"+"<br>");
            writer.println("<ul>");
            writer.println("<li>Hasło powinno zaiwrać co najmniej jedną wielką literę</li>");
            writer.println("<li>Hasło powinno zaiwrać co najmniej jedną cyfrę</li>");
            writer.println("<li>Hasło powinno mieć minimalną długość 5 znaków</li>");
        }
        writer.println("Płeć: " +user.getGender() + "<br>");
        if(user.getHobby() != null) {
            writer.print("Hobby: <br>");
            for(String hobby: user.getHobby())
                writer.println(" " + hobby + "<br>");
        }
        writer.print("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
    public boolean passwordLength(String password){
        if (password.length()>=5)
            return true;
        else return false;
    }
    public boolean bigLetter(String password){
        boolean bigL= false;
        char[] chars = password.toCharArray();
        for (char letter:chars) {
            if (Character.isUpperCase(letter))
                return bigL=true;
        }return bigL;

    }
    public boolean hasDigit(String password){
        boolean digit=false;
        char[] chars = password.toCharArray();
        for (char letter:chars) {
            if (Character.isDigit(letter))
                digit=true;

        }
        return digit;
    }

}