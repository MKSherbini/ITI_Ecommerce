package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.orm.ProductCategory;
import providers.repositories.CategoryRepo;

import java.io.IOException;

@WebServlet("/addcategory")
public class AddCategoryController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryName = request.getParameter("categoryName");
        if(categoryName!=null){
            ProductCategory category = new ProductCategory(categoryName);
            CategoryRepo.getInstance().create(category);
            response.setStatus(200);
            return;
        }
        response.setStatus(500);
    }
}
