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
import models.dtos.CategoryDto;
import models.dtos.ShopPageDto;
import models.orm.Product;
import models.orm.ProductCategory;
import providers.repositories.CategoryRepo;
import providers.repositories.ProductRepo;
import utilities.SafeConverter;
import utilities.adapters.CategoryAdapter;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        // fetch params
        var paramCategories = request.getParameterValues(WebsiteConstants.paramCategoryName);
        var paramSearch = request.getParameter(WebsiteConstants.paramSearchName);
        if (paramSearch == null) paramSearch = "";
        var priceRange = productRepo.findMinMaxPriceLikeName(paramSearch);
        var minPriceDefault = priceRange[0] == null ? 0 : (int) priceRange[0];
        var maxPriceDefault = priceRange[1] == null ? 0 : (int) priceRange[1];
        var paramMinPrice = SafeConverter.safeIntParse(request.getParameter(WebsiteConstants.paramMinPriceName), minPriceDefault);
        var paramMaxPrice = SafeConverter.safeIntParse(request.getParameter(WebsiteConstants.paramMaxPriceName), maxPriceDefault);
        var paramPageNumber = Math.max(SafeConverter.safeIntParse(request.getParameter(WebsiteConstants.paramPageNumber), 1), 1);
        var pageSize = 12;


        // process params
//        var categoryList = CategoryAdapter.copyOrmToDto(categoryRepo.readAll());
        // process products
        List<Product> productList;
        if (paramCategories == null) {
            productList = productRepo.findByPriceName(
                    paramMinPrice, paramMaxPrice, paramSearch);
        } else {
            productList = productRepo.findByMultiCategoryPriceName(paramCategories,
                    paramMinPrice, paramMaxPrice, paramSearch);
        }
        var numberOfPages = (int) Math.ceil((1.0 * productList.size()) / pageSize);
        // handle paging of products
        productList = productList.stream().skip((long) (paramPageNumber - 1) * pageSize).limit(pageSize).collect(Collectors.toList());

        var categoryList = productRepo.findLikeName(paramSearch).stream().map(Product::getCategory).collect(Collectors.groupingBy(ProductCategory::getName))
                .entrySet().stream().map(stringListEntry -> new CategoryDto(stringListEntry.getKey(), stringListEntry.getValue().size())).sorted(Comparator.comparing(CategoryDto::getName)).collect(Collectors.toList());
        var pageList = IntStream.rangeClosed(1, numberOfPages).mapToObj(num -> new ShopPageDto(num, num == paramPageNumber)).collect(Collectors.toList());

        // retain categories in ui
        if (paramCategories != null && paramCategories.length > 0)
            categoryList.forEach(categoryDto -> categoryDto.setSelected(Arrays.stream(paramCategories)
                    .anyMatch(s -> s.equals(categoryDto.getName()))));

        // add to request scope
        request.setAttribute("productList", productList);
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("paramSearch", paramSearch);
        request.setAttribute("requestParams", request.getParameterMap());
        request.setAttribute("paramMinPrice", paramMinPrice);
        request.setAttribute("paramMaxPrice", paramMaxPrice);
        request.setAttribute("numberOfPages", numberOfPages);
        request.setAttribute("pageList", pageList);
        request.setAttribute("pageHasNext", paramPageNumber < numberOfPages);
        request.setAttribute("pageHasPrev", paramPageNumber > 1);
        request.setAttribute("paramPageNumber", paramPageNumber);


        // render ui
        request.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.SHOP)).include(request, response);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
