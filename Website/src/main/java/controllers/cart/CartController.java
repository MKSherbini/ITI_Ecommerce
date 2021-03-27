package controllers.cart;

import constants.UrlMappingConstants;
import constants.WebsiteConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.dtos.CartDto;
import models.dtos.CategoryDto;
import models.dtos.ShopPageDto;
import models.orm.Product;
import models.orm.ProductCategory;
import providers.repositories.CategoryRepo;
import providers.repositories.ProductRepo;
import utilities.SafeConverter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@WebServlet("/cart")
public class CartController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var cartDto = (CartDto) request.getSession().getAttribute("cart");

        // render ui
        if (cartDto.getCartItems().size() == 0)
            request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.EMPTY_CART)).include(request, response);
        else
            request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.CART)).include(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
