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
import models.orm.ProductImage;
import providers.repositories.CategoryRepo;
import providers.repositories.ProductImageRepo;
import providers.repositories.ProductRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
        Collection<Part> productImagesParts = request.getParts();
        String productDescription = request.getParameter("productDescription");
        String categoryName = request.getParameter("category");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int discount = Integer.parseInt(request.getParameter("discount"));
        FireStorageManager fireStorageManager = FireStorageManager.getInstance();
        List<ProductImage> productImages = new ArrayList<>();
        int count = 1;
        for (Part image:
                productImagesParts) {
            if(image.getName().contains("image") && !image.getSubmittedFileName().equals("")){
                System.out.println(image.getName());
                String downloadLink = fireStorageManager.uploadFileToStorage(image.getInputStream().readAllBytes(), name+count);
                productImages.add(new ProductImage(downloadLink));
                count++;
                System.out.println(count);
            }

        }
        System.out.println(request.getContextPath());
        Optional<ProductCategory> productCategory = CategoryRepo.getInstance().findByName(categoryName);
        if(productCategory.isPresent()) {
            Product product = new Product(name, price, productDescription, quantity, discount, productCategory.get(),productImages);
            ProductRepo.getInstance().create(product);
            for(int i=0;i<productImages.size();i++){
                productImages.get(i).setProduct(product);
//                ProductImageRepo.getInstance().create(productImages.get(i));
            }
            ProductRepo.getInstance().create(product);

        }

    }
        public String getServletInfo() {
        return null;
    }

    public void destroy() {}

}
