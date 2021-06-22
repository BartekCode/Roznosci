package servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/allparams")
public class AllParamsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        setContentType(response);
       sendHtmlRespone(request,response);

        }

    private void setContentType(HttpServletResponse response) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
    }

    private void sendHtmlRespone(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head></head>");
        writer.println("<body>");
        writer.println("<ol>");
        for (String key : parameterMap.keySet()) {
            writer.printf("<li>%s</li>\n",key);
            for (String value : parameterMap.get(key)) {
                writer.println("<ul>");
                writer.printf("<li>%s</li>\n", value);
                writer.println("</ul>");
            }
        }
        writer.println("</ol>");
        writer.println("</body>");
        writer.println("</html>");

    }

}