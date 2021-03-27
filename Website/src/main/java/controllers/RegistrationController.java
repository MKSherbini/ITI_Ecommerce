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
import models.orm.DummyUser;
import models.orm.User;
import providers.repositories.CartRepo;
import providers.repositories.DummyUserRepo;
import providers.repositories.UserRepo;
import utilities.Hashator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.sql.Date;

@WebServlet("/signup")
public class RegistrationController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside registration controller");
        var user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.HOME_PAGE));
            return;
        }
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
        DummyUser dummyUser = (DummyUser) request.getSession().getAttribute("dummyUser");

        if (email != null && password != null && firstName != null && lastName != null && userName != null && birthDateParam != null) {
            Date birthDate = null;
            birthDate = Date.valueOf(birthDateParam);
            System.out.println(birthDate);
            String hashedPassword = Hashator.getInstance().hash(password);
            User user = new User(email, userName, hashedPassword, firstName, lastName, birthDate);
            UserRepo userRepo = UserRepo.getInstance();
            userRepo.create(user);

            // hijack the dummy user
            if (dummyUser != null) {
                CartRepo.getInstance().updateDummyToUser(dummyUser, user);
                DummyUserRepo.getInstance().delete(dummyUser);
            } else {
                System.out.println("Where dafuq is dummyUser");
            }


            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.SIGN_IN_PAGE));
        }
    }
}
