package controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.*;

@WebServlet("/signout")
public class SignoutController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession(false);
        if (session != null)
            session.invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
