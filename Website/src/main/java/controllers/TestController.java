package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.orm.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/test")
public class TestController extends HttpServlet {
    ServletConfig myConfig;
    List<Product> productList = new ArrayList<>();

    {
//        productList.add(new Product(1L, "test1", 100, "TestCat1", "testDesc1", 1, "images/product/electronic/product1.jpg", 1));
//        productList.add(new Product(2L, "test2", 200, "TestCat2", "testDesc2", 2, "images/product/electronic/product2.jpg", 2));
    }

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("productList", productList);
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.TEST_JSP)).include(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
