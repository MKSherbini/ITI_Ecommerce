package controllers.services;


import com.google.gson.Gson;
import constants.WebsiteConstants;
import constants.enums.PageNames;
import constants.enums.PaymentMethod;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;
import models.orm.Product;
import models.orm.User;
import providers.repositories.CartRepo;
import providers.repositories.ProductRepo;
import utilities.ErrorHandler;
import utilities.SafeConverter;
import utilities.adapters.ProductAdapter;

import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

@WebServlet("/payment")
public class PaymentService extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // try checkout
        CartRepo cartRepo = CartRepo.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        var paramPaymentMethod = request.getParameter(WebsiteConstants.paramPaymentMethod);


        if (user == null || paramPaymentMethod == null) {
            ThreadLocalContext.sendRedirect(PageNames.SIGN_IN_PAGE);
            return;
        }

        var cart = cartRepo.submitOrder(user, PaymentMethod.valueOf(paramPaymentMethod.toUpperCase()));
        System.out.println("PaymentMethod.valueOf(paramPaymentMethod.toUpperCase()) = " + PaymentMethod.valueOf(paramPaymentMethod.toUpperCase()));

        // todo if failed go to error page
        if (cart.isEmpty()) {
            ErrorHandler.forward("666", "Can't complete checkout, try again later");
        } else {
            // todo if succeeded go to somewhere else
            ThreadLocalContext.sendRedirect(PageNames.HOME_PAGE);
        }

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
