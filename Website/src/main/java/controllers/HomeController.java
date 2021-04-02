package controllers;

import constants.UrlMappingConstants;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import constants.enums.PageNames;
import models.orm.Product;
import models.orm.ProductCategory;
import providers.repositories.CategoryRepo;
import providers.repositories.CustomerReviewRepo;
import providers.repositories.ProductRepo;

import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // do preparing
        //todo get all categories
        CategoryRepo categoryRepo = CategoryRepo.getInstance();
        List<ProductCategory> categories = categoryRepo.readAll();
        request.setAttribute("categories",categories);
        //todo try to use pagination while getting products
        //todo get new arrivals
        ProductRepo productRepo = ProductRepo.getInstance();
        List<Product> newArrivals = productRepo.findNewArrivals();
        request.setAttribute("newArrivals",newArrivals);
        //to present customer reviews
        request.setAttribute("reviews", CustomerReviewRepo.getInstance().readAll());

        System.out.println("HomeController.doGet");
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.HOME_PAGE)).include(request, response);
        // do verifying
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
