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
import models.orm.Developer;
import providers.repositories.DeveloperRepo;

import javax.transaction.Transaction;
import java.io.IOException;
import java.util.List;

@WebServlet("/about")
public class AboutController extends HttpServlet {
    public static final String DEVELOPERS_NAME="developers";
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //todo solve the problem of named query of the developer repo

        List<Developer> developers = DeveloperRepo.getInstance().findAll();
        request.setAttribute(DEVELOPERS_NAME,developers);
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.ABOUT_PAGE)).include(request,response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {}


}
