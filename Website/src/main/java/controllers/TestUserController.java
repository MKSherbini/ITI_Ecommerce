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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/testUser")
public class TestUserController extends HttpServlet {
    ServletConfig myConfig;
    List<User> userList = new ArrayList<>();

    {
        userList.add(new User(1L, "moha", "osos", "kaed", "123456aB*", "mohaelkaed@gmail.com"));
        userList.add(new User(1L, "moha", "osos", "kaed", "123456aB*", "mohaelkaed@gmail.com"));
        userList.add(new User(2L, "moham","sherbini", "sherbo", "123456aB*", "sherbo@gmail.com"));
    }

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userList", userList);
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.TEST_USER_JSP)).include(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}