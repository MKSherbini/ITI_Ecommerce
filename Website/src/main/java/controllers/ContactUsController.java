package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import managers.DatabaseManager;
import models.orm.CustomerMessage;
import models.orm.Subscriber;
import providers.repositories.CustomerMessageRepo;
import providers.repositories.SubscriberRepo;
import utilities.EmailUtil;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/contact")
public class ContactUsController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.CONTACT_US)).include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        String email = request . getParameter("email");
        String subject = request.getParameter("subject");
        String name = request.getParameter("name");
        String gender = "Male";
        // todo check if the user is signed in use his email and subscriber data
        Subscriber subscriber = new Subscriber(name,email,new Date(new java.util.Date().getTime()),gender);

        SubscriberRepo.getInstance().create(subscriber);
        CustomerMessage customerMessage = new CustomerMessage(message, subject,new Date(new java.util.Date().getTime()) );
        customerMessage.setSubscriber(subscriber);
        CustomerMessageRepo.getInstance().create(customerMessage);

        EmailUtil.sendEmail(email,"Message Confirmation-NoReply","Hello "+name+" , Thanks for your message , we confirm you that received your message and will contact with you in two days . ");
        response.setContentType("text/plain");
        response.getWriter().println("ok" );
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
