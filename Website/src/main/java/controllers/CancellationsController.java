package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;
import models.orm.User;
import providers.repositories.CartRepo;
import utilities.ErrorHandler;

import java.io.IOException;

@WebServlet("/cancellations")
public class CancellationsController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.SIGN_IN_PAGE));
            return;
        }
        request.setAttribute("ordersCount", CartRepo.getInstance().findHistoryByUser(user).size());
        ThreadLocalContext.includeView(PageNames.CANCELLATIONS);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
