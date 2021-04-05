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
import models.orm.Address;
import models.orm.User;
import providers.repositories.UserRepo;

import java.io.IOException;
import java.sql.Date;


@WebServlet("/editAddress")
public class EditAddressController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside editAddress Controller");
        var user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.Edit_ADDRESS));
            requestDispatcher.include(request, response);
            return;
        }
        response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.SIGN_IN_PAGE));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post method editAddress");
        HttpSession session = request.getSession();
        User editedUser = (User) session.getAttribute("user");
        String streetAddress = request.getParameter("streetName");
        String cityAddress = request.getParameter("addressCity");
        String stateAddress = request.getParameter("addressState");
        String countryAddress = request.getParameter("addressCountry");
        String zipPostalAddress = request.getParameter("zipPostalCode");
        System.out.println("zipPostalAddress + countryAddress + stateAddress + streetAddress + cityAddress = " + zipPostalAddress + countryAddress + stateAddress + streetAddress + cityAddress);
        Address address = new Address(streetAddress,countryAddress,cityAddress,stateAddress,zipPostalAddress);
        editedUser.setAddress(address);
        UserRepo userRepo = UserRepo.getInstance();
        userRepo.update(editedUser);
        response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.ADDRESS_BOOK));

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }

}
