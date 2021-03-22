package controllers.shop;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import providers.repositories.ProductRepo;

import java.io.IOException;

@WebServlet("/shop")
public class ShopController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // do preparing
        ProductRepo productRepo = ProductRepo.getInstance();

        var productList = productRepo.readAll();
        request.setAttribute("productList", productList);

        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.SHOP)).include(request, response);
        // do verifying
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
