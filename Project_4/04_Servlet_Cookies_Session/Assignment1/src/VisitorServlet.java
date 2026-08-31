import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        boolean returningVisitor = false;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visited".equals(cookie.getName())) {
                    returningVisitor = true;
                    break;
                }
            }
        }

        out.println("<html>");
        out.println("<head><title>Visitor</title></head>");
        out.println("<body>");

        if (returningVisitor) {
            out.println("<h1>Welcome Back</h1>");
        } else {
            out.println("<h1>Welcome, you are visiting for the first time</h1>");

            Cookie visitedCookie = new Cookie("visited", "true");
            visitedCookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(visitedCookie);
        }

        out.println("</body>");
        out.println("</html>");
    }
}