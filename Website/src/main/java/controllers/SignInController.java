package controllers;

import constants.UrlMappingConstants;
import constants.WebsiteConstants;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import constants.enums.PageNames;

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
        System.out.println("test");
        String email = request.getParameter("emailN");
        String password = request.getParameter("passN");
        if (email != null && password != null && email.equals(WebsiteConstants.email) && password.equals(WebsiteConstants.Password)) {
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.HOME_PAGE));
            return;
        } else {
            request.setAttribute("userError", true);
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.NOT_FOUND_404));

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
