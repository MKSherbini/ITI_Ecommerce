package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import providers.repositories.UserRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

@WebServlet("/userDash")
public class UserDashboardController extends HttpServlet {
    private ServletConfig config ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> users = new ArrayList<>();
        UserRepo.getInstance().readAll().stream().forEach((u)->{
            users.add(new User(u.getUserId(),u.getFirstName(),u.getLastName(),u.getUserName(),u.getEmail(),u.getBirthdate(),u.getAddress().getCountry()));
        });
        req.setAttribute("users",users);
        req.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.USER_DASH_PAGE)).include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        this.config = config ;
    }

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
