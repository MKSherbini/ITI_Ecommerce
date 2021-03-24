package controllers;

import constants.UrlMappingConstants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import constants.enums.PageNames;
import models.orm.User;
import providers.repositories.UserRepo;

import java.io.IOException;

@WebServlet(urlPatterns = {"/","/home"})
public class HomeController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // do preparing
//        var userRepo = UserRepo.getInstance();
//        for (User user : userRepo.findLikeName("t")) {
//            System.out.println("user = " + user);
//        }
//        User user = new User();
//        user.setEmail("testmain");
//        user.setUserName("testmain");
//        user.setPassword("testmain");
//        userRepo.create(user);
//        System.out.println("user = " + userRepo.read(user.getUserId()));

        System.out.println("HomeController.doGet");
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.HOME_PAGE)).include(request, response);
        // do verifying
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
