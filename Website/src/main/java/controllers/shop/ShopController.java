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
import utilities.SafeConverter;
import utilities.adapters.CategoryAdapter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
        ProductRepo productRepo = ProductRepo.getInstance();
        CategoryRepo categoryRepo = CategoryRepo.getInstance();

        var paramCategories = request.getParameterValues(WebsiteConstants.paramCategoryName);
        var paramSearch = request.getParameter(WebsiteConstants.paramSearchName);
        if (paramSearch == null) paramSearch = "";
        var paramMinPrice = SafeConverter.safeIntParse(request.getParameter(WebsiteConstants.paramMinPriceName), 0);
        var paramMaxPrice = SafeConverter.safeIntParse(request.getParameter(WebsiteConstants.paramMaxPriceName), Integer.MAX_VALUE);

        var categoryList = CategoryAdapter.copyOrmToDto(categoryRepo.readAll());
        List<Product> productList;
        if (paramCategories == null) {
            productList = productRepo.findByPriceName(
                    paramMinPrice, paramMaxPrice, paramSearch);
        } else {
            productList = productRepo.findByMultiCategoryPriceName(paramCategories,
                    paramMinPrice, paramMaxPrice, paramSearch);
        }

        if (paramCategories != null && paramCategories.length > 0)
            categoryList.forEach(categoryDto -> categoryDto.setSelected(Arrays.stream(paramCategories)
                    .anyMatch(s -> s.equals(categoryDto.getName()))));

        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("paramSearch", paramSearch);
        request.setAttribute("requestParams", request.getParameterMap());
        request.setAttribute("paramMinPrice", paramMinPrice);
        request.setAttribute("paramMaxPrice", paramMaxPrice);
        // add price min/max

        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.SHOP)).include(request, response);
        // do verifying
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
