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
import models.orm.Product;
import providers.repositories.ProductRepo;
import utilities.SafeConverter;
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
        ProductRepo productRepo = ProductRepo.getInstance();
        var out = response.getOutputStream();
        var paramProduct = request.getParameter(WebsiteConstants.paramProductId);
        Optional<Product> product = Optional.empty();
        if (paramProduct != null) {
            product = productRepo.read(SafeConverter.safeLongParse(paramProduct, 0L));
        }

        if (paramProduct == null || product.isEmpty()) {
            out.print("");
            return;
        }

        var productDto = ProductAdapter.copyOrmToDto(product.get());
        out.print(new Gson().toJson(productDto));
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
