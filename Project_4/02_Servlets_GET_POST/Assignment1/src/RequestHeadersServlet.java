import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeadersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Request Headers</title></head>");
        out.println("<body>");

        out.println("<h1>Request Headers</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

        Enumeration<String> headers = request.getHeaderNames();

        while (headers.hasMoreElements()) {

            String headerName = headers.nextElement();
            String headerValue = request.getHeader(headerName);

            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + headerValue + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}