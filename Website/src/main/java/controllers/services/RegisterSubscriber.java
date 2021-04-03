package controllers.services;


import com.google.gson.Gson;
import constants.WebsiteConstants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.Email;
import managers.DatabaseManager;
import models.orm.*;
import providers.repositories.CartRepo;
import providers.repositories.ProductRepo;
import providers.repositories.SubscriberRepo;
import utilities.EmailUtil;
import utilities.SafeConverter;
import utilities.adapters.ProductAdapter;

import java.io.IOException;
import java.sql.Date;
import java.util.Optional;

@WebServlet("/registerSubscriber")
public class RegisterSubscriber extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }
    public void doGet(HttpServletRequest request , HttpServletResponse response )throws ServletException, IOException {
        response.setContentType("text/plain");
        SubscriberRepo.getInstance().readAll().stream().filter((s)->s.getEmail().equals(request.getParameter("email"))).findFirst().ifPresent((subscriber)-> {
            try {
                response.getWriter().println("exists");

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        SubscriberRepo.getInstance().create(
                new Subscriber(null, email,
                        new Date(new java.util.Date().getTime()),request.getParameter("gender")));
        response.getWriter().println("Successfully subscribed in the site check your email .");
        EmailUtil.sendEmail(email,"Confirm Subscription","Dear "+(gender.equals("Male")?"Mr. ":"Mss. ")+
                " Thank you for your subscription to Ludus.com this mean that you are agree to " +
                "receive emails with news and offers form Ludus.com ");

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
