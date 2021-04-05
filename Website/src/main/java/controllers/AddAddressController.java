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
import models.orm.User;
import providers.repositories.CartRepo;

import java.io.IOException;


@WebServlet("/addAddress")
public class AddAddressController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside AddAddress Controller");
        var user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.SIGN_IN_PAGE));
            return;
        }
        request.setAttribute("ordersCount", CartRepo.getInstance().findHistoryByUser(user).size());
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.ADD_ADDRESS));
            requestDispatcher.include(request, response);
            return;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

}
