package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import models.orm.User;
import providers.repositories.UserRepo;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

@WebServlet("/editProfile")
public class EditProfileController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside EditAccount controller");
        var user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.EditProfile));
            requestDispatcher.include(request, response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getControllerUrl(PageNames.Profile));
            requestDispatcher.forward(request, response);
        }
    }

    @SneakyThrows
    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        User editedUser = (User) session.getAttribute("user");
        String firstName = request.getParameter("reg-fname");
        String lastName = request.getParameter("reg-lname");
        String birthDate = request.getParameter("bdate");
       // Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        String gender = request.getParameter("geneder");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        UserRepo userRepo = UserRepo.getInstance();
        if (firstName != null && lastName != null && email != null) {
            editedUser.setFirstName(firstName);
            editedUser.setLastName(lastName);
            editedUser.setEmail(email);
           // editedUser.setBirthdate(date);
        }
        userRepo.update(editedUser);
        response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.Profile));
    }
}