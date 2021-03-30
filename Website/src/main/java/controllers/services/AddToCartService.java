package controllers.services;


import com.google.gson.Gson;
import constants.UrlMappingConstants;
import constants.WebsiteConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import managers.CookiesManager;
import managers.DatabaseManager;
import models.dtos.CartDto;
import models.orm.*;
import providers.repositories.CartItemRepo;
import providers.repositories.CartRepo;
import providers.repositories.ProductRepo;
import utilities.SafeConverter;
import utilities.adapters.CartAdapter;
import utilities.adapters.ProductAdapter;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/addToCart")
public class AddToCartService extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        ProductRepo productRepo = ProductRepo.getInstance();
        CartRepo cartRepo = CartRepo.getInstance();
        User user = (User) request.getSession().getAttribute("user");
        DummyUser dummyUser = (DummyUser) request.getSession().getAttribute("dummyUser");
        var out = response.getOutputStream();
        var paramProduct = request.getParameter(WebsiteConstants.paramProductId);
        var paramAddProductQuantityName = Math.max(1, SafeConverter.safeIntParse(request.getParameter(WebsiteConstants.paramAddProductQuantityName), 1));

        Optional<Product> product = Optional.empty();
        if (paramProduct != null) {
            product = productRepo.read(SafeConverter.safeLongParse(paramProduct, 0L));
        }

        if (paramProduct == null || product.isEmpty()) {
            out.print("{\"status\":\"bad\"}");
            return;
        }

        int addedItems = 0;
        if (user == null)
            addedItems = cartRepo.addProduct(dummyUser, product.get(), paramAddProductQuantityName);
        else
            addedItems = cartRepo.addProduct(user, product.get(), paramAddProductQuantityName);

        if (addedItems == -1) {
            out.print("{\"status\":\"bad\"}");
            return;
        }

        //DatabaseManager.getInstance().flush();
        Optional<ShoppingCart> cart;

        if (user == null)
            cart = cartRepo.findShoppingCartByDummyUser(dummyUser);
        else
            cart = cartRepo.findShoppingCartByUser(user);

//        System.out.println("cart = " + cart.get().getCartItems());
//        CartRepo.getInstance().refresh(cart.get());
//        System.out.println("cart = " + cart.get().getCartItems());
        // todo fk this, why did I fking have to call fking refresh?
//        request.getSession().setAttribute("cart", cart.get());

        var addedProductDto = ProductAdapter.copyOrmToCartDto(product.get(), cart.get());
        addedProductDto.setAddedQuantity(addedItems);

        out.print(new Gson().toJson(addedProductDto));
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
