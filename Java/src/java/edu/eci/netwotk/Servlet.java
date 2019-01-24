package edu.eci.netwotk;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Search myClass = new Search();

        if (request.getParameter("data") != null) {
            myClass.setUrl(request.getParameter("data"));
            String[] args = null;
            myClass.main(args);
        }

        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }    

}
