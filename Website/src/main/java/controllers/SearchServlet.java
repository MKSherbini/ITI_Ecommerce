package controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import managers.DatabaseManager;
import providers.repositories.UserRepo;

import java.io.*;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        var userRepo = UserRepo.getInstance();
        request.setAttribute("result", userRepo.searchContacts(request.getParameter("query")));
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
