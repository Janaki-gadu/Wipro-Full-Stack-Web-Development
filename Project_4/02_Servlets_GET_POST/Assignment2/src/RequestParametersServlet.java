import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/parameters")
public class RequestParametersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        displayParameters(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        displayParameters(request, response);
    }

    private void displayParameters(HttpServletRequest request,
                                   HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head><title>Submitted Parameters</title></head>");
        out.println("<body>");

        out.println("<h1>Submitted Parameters</h1>");

        out.println("<table border='1' cellpadding='8'>");
        out.println("<tr>");
        out.println("<th>Parameter Name</th>");
        out.println("<th>Parameter Value</th>");
        out.println("</tr>");

        Enumeration<String> parameterNames =
                request.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String parameterName = parameterNames.nextElement();

            String[] parameterValues =
                    request.getParameterValues(parameterName);

            for (String value : parameterValues) {

                out.println("<tr>");
                out.println("<td>" + parameterName + "</td>");
                out.println("<td>" + value + "</td>");
                out.println("</tr>");
            }
        }

        out.println("</table>");

        out.println("</body>");
        out.println("</html>");
    }
}