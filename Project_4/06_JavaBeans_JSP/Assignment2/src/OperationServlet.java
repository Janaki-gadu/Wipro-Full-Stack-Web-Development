import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/operation")
public class OperationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        int operation = Integer.parseInt(
                request.getParameter("operation"));

        if (operation < 10) {

            request.getRequestDispatcher("page1.jsp")
                   .forward(request, response);

        } else if (operation >= 10 && operation < 100) {

            request.getRequestDispatcher("page2.jsp")
                   .forward(request, response);

        } else {

            request.getRequestDispatcher("error.jsp")
                   .forward(request, response);
        }
    }
}