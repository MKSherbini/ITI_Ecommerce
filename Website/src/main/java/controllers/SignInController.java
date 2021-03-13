package controllers;

import constants.UrlMappingConstants;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.enums.PageNames;

import java.io.*;

@WebServlet("/signin")
public class SignInController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // do preparing
        System.out.println("SignInController.doGet");
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.SIGN_IN_PAGE)).include(request, response);
        System.out.println("SignInController.doGet");
        // do verifying
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // do preparing
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email != null && password != null && email.equals("ali@ali.ali") && password.equals("ali")) {
            response.sendRedirect(UrlMappingConstants.getInstance().getViewUrl(PageNames.HOME_PAGE));
            return;
        } else {
            request.setAttribute("userError", true);
        }

        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.SIGN_IN_PAGE)).include(request, response);
        // do verifying
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
