import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
    name = "ConfigContextServlet",
    urlPatterns = "/config-context",
    initParams = {
        @jakarta.servlet.annotation.WebInitParam(
            name = "servletMessage",
            value = "This is a ServletConfig parameter"
        )
    }
)
public class ConfigContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        ServletConfig config = getServletConfig();
        ServletContext context = getServletContext();

        String configValue =
                config.getInitParameter("servletMessage");

        out.println("<html>");
        out.println("<head><title>Servlet Config and Context</title></head>");
        out.println("<body>");

        out.println("<h1>Servlet Config and Servlet Context Parameters</h1>");

        out.println("<h2>ServletConfig Parameter</h2>");
        out.println("<p>Name: servletMessage</p>");
        out.println("<p>Value: " + configValue + "</p>");

        out.println("<h2>ServletContext Parameters</h2>");

        out.println("<p>Name: applicationName</p>");
        out.println("<p>Value: " +
                context.getInitParameter("applicationName") +
                "</p>");

        out.println("<p>Name: trainingProgram</p>");
        out.println("<p>Value: " +
                context.getInitParameter("trainingProgram") +
                "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}