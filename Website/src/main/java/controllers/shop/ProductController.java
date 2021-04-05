package controllers.shop;

import constants.UrlMappingConstants;
import constants.WebsiteConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.orm.Product;
import providers.repositories.CategoryRepo;
import providers.repositories.ProductRepo;
import utilities.ErrorHandler;
import utilities.SafeConverter;
import utilities.adapters.CategoryAdapter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet("/product")
public class ProductController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductRepo productRepo = ProductRepo.getInstance();

        var paramProduct = request.getParameter(WebsiteConstants.paramProductId);
        Optional<Product> product = Optional.empty();
        if (paramProduct != null) {
            product = productRepo.read(SafeConverter.safeLongParse(paramProduct, 0L));
        }

        if (paramProduct == null || product.isEmpty()) {
            ErrorHandler.forward("666", "No such product");
            return;
        }

        request.setAttribute("product", product.get());
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.PRODUCT)).include(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
