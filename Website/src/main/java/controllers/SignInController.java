package controllers;

import constants.UrlMappingConstants;
import jakarta.json.Json;
import jakarta.json.JsonObjectBuilder;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import constants.enums.PageNames;
import utilities.Hashator;

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
        String rememberMe = request.getParameter("rememberMe");
        if(rememberMe!=null && rememberMe.equals("true")){
            String hashedPassword = Hashator.getInstance().hash(password);
            // todo hash both email and password together in one String with reversible hashing before saving it in cookie
            String userInfo = email+":"+hashedPassword;
            Cookie userCookie = new Cookie("User",userInfo);
            response.addCookie(userCookie);
        }
        if (email != null && password != null && email.equals("ali@ali.ali") && password.equals("ali")) {
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.HOME_PAGE));
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
