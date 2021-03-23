package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import constants.enums.ServiceNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;

import java.io.IOException;

@WebServlet("/errorRedirect")
public class ErrorRedirect extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.TEST_JSP));
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
