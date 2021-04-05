package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.orm.ShoppingCart;
import models.orm.User;
import providers.repositories.CartRepo;
import utilities.ErrorHandler;

import java.io.IOException;
import java.util.List;

@WebServlet("/myorders")
public class OrdersHistoryController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.SIGN_IN_PAGE));
            return;
        }
        List<ShoppingCart> userOrders = CartRepo.getInstance().findHistoryByUser(user);
        request.setAttribute("orders", userOrders);
        request.setAttribute("ordersCount", userOrders.size());
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.MY_ORDERS)).include(request, response);
    }
}
