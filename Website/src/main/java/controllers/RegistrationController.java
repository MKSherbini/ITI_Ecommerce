package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/signup")
public class RegistrationController extends HttpServlet {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside registration controller");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.REGISTER_PAGE));
        requestDispatcher.include(request,response);
    }
}
