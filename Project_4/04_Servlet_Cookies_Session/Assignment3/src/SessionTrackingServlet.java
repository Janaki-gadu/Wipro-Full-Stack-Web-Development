import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionTrackingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        Integer visitCount =
                (Integer) session.getAttribute("visitCount");

        if (visitCount == null) {
            visitCount = 1;
        } else {
            visitCount++;
        }

        session.setAttribute("visitCount", visitCount);

        out.println("<html>");
        out.println("<head><title>Session Tracking</title></head>");
        out.println("<body>");

        out.println("<h1>Session Tracking</h1>");

        out.println("<h2>Session Information</h2>");

        out.println("<p><b>Number of Visits:</b> "
                + visitCount + "</p>");

        out.println("<p><b>Session ID:</b> "
                + session.getId() + "</p>");

        out.println("<p><b>Creation Time:</b> "
                + new java.util.Date(session.getCreationTime())
                + "</p>");

        out.println("<p><b>Last Accessed Time:</b> "
                + new java.util.Date(session.getLastAccessedTime())
                + "</p>");

        out.println("<p><b>Maximum Inactive Interval:</b> "
                + session.getMaxInactiveInterval()
                + " seconds</p>");

        out.println("</body>");
        out.println("</html>");
    }
}