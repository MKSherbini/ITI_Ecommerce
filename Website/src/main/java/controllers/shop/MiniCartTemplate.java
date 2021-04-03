package controllers.shop;


import com.google.gson.Gson;
import constants.WebsiteConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;
import models.orm.DummyUser;
import models.orm.Product;
import models.orm.ShoppingCart;
import models.orm.User;
import providers.repositories.CartRepo;
import providers.repositories.ProductRepo;
import utilities.SafeConverter;
import utilities.adapters.ProductAdapter;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/miniCart")
public class MiniCartTemplate extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ThreadLocalContext.includeView(PageNames.MINI_CART);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
