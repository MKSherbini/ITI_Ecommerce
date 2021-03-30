package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import managers.FireStorageManager;
import models.orm.Product;
import models.orm.ProductCategory;
import providers.repositories.CategoryRepo;
import providers.repositories.ProductRepo;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/addproduct")
@MultipartConfig
public class AddProductController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categories", CategoryRepo.getInstance().findAllNames());
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.ADD_PRODUCT)).include(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Part imagePart = request.getPart("image");
        String productDescription = request.getParameter("productDescription");
        String categoryName = request.getParameter("category");
        System.out.println(categoryName);
        System.out.println(request.getParameter("price")+"mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        FireStorageManager fireStorageManager = new FireStorageManager();
        String downloadLink = fireStorageManager.uploadFileToStorage(imagePart.getInputStream().readAllBytes());
        System.out.println(request.getContextPath());
        Optional<ProductCategory> productCategory = CategoryRepo.getInstance().findByName(categoryName);
        if(productCategory.isPresent()) {
            Product product = new Product(name, price, productDescription, quantity, downloadLink, productCategory.get());
            product.setDiscountPercent(discount);
            ProductRepo.getInstance().create(product);
        }

    }


        public String getServletInfo() {
        return null;
    }

    public void destroy() {}

}
