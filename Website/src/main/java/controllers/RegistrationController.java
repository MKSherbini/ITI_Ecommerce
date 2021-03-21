package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import managers.DatabaseManager;
import models.orm.User;
import providers.repositories.UserRepo;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;

@WebServlet("/signup")
public class RegistrationController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside registration controller");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.REGISTER_PAGE));
        requestDispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside registration post");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("userName");
        String birthDateParam = request.getParameter("birthDate");
        if (email != null && password != null && firstName != null && lastName != null && userName != null && birthDateParam != null) {
            Date birthDate = null;
            birthDate = Date.valueOf(birthDateParam);
            System.out.println(birthDate);
            User user = new User(email, userName, password, firstName, lastName, birthDate);
            UserRepo userRepo = UserRepo.getInstance();
            userRepo.create(user);
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.SIGN_IN_PAGE));
        }
    }
}
