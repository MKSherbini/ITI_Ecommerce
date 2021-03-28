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
import models.orm.User;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Calendar;

@WebServlet("/account")
public class AccountController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("inside EditAccount controller");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.REGISTER_PAGE));
        requestDispatcher.include(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();

       User user1 = (User) session.getAttribute("user");

        String firstName = request.getParameter("reg-fname");
        String lastName = request.getParameter("reg-lname");
        String  birthDate = request.getParameter("bdate");
        /*Calendar c = Calendar.getInstance();
        c.set(1996,07,04);*/
        String gender = request.getParameter("geneder");
        String email =request.getParameter("email");
        String mobile = request.getParameter("mobile");


    }
}
