package controllers.services;


import com.google.gson.Gson;
import constants.WebsiteConstants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.orm.*;
import providers.repositories.CartRepo;
import providers.repositories.ProductRepo;
import utilities.SafeConverter;
import utilities.adapters.ProductAdapter;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/removeFromCart")
public class RemoveFromCartService extends HttpServlet {
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
        Optional<Product> product = Optional.empty();
        if (paramProduct != null) {
            product = productRepo.read(SafeConverter.safeLongParse(paramProduct, 0L));
        }

        if (paramProduct == null || product.isEmpty()) {
            out.print("{'status':'bad'}");
            return;
        }

        Optional<ShoppingCart> cart;
        if (user == null)
            cart = cartRepo.removeProduct(dummyUser, product.get());
        else
            cart = cartRepo.removeProduct(user, product.get());

        if (cart.isEmpty()) {
            out.print("{'status':'bad'}");
            return;
        }

        var cartItems = cart.get().getCartItems();

//        cartItems.add()
        var addedProductDto = ProductAdapter.copyOrmToCartDto(product.get());
        if (cartItems.size() > 0)
            addedProductDto.setTotalInCart(cartItems.stream().mapToInt(CartItem::getProductQuantity).sum());

        out.print(new Gson().toJson(addedProductDto));
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
