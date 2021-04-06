package controllers.wishlist;


import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;
import models.orm.User;
import providers.repositories.ProductRepo;
import providers.repositories.UserRepo;
import utilities.SafeConverter;

import java.io.IOException;

@WebServlet("/wishlist")
public class WishlistController extends HttpServlet {
    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            ThreadLocalContext.sendRedirect(PageNames.SIGN_IN_PAGE);
            return;
        }
        var paramId = SafeConverter.safeLongParse(request.getParameter("ref"), -1L);
        var wishlist = user.getWishlist();
        System.out.println("paramId = " + request.getParameter("ref"));
        System.out.println("paramId = " + paramId);
        if (paramId != -1L) {
            // add to wishlist
            var found = false;
            for (var item : wishlist) {
                if (item.getProductId().equals(paramId)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("wishlist product not found");
                var product = ProductRepo.getInstance().read(paramId);
                product.ifPresent(wishlist::add);
                user.setWishlist(wishlist);
                System.out.println("wishlist = " + wishlist);
                UserRepo.getInstance().update(user);
            }
        }

        request.setAttribute("wishlist", user.getWishlist());
        ThreadLocalContext.includeView(PageNames.WISHLIST);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return;
        }
        var paramId = SafeConverter.safeLongParse(request.getParameter("ref"), -1L);
        var wishlist = user.getWishlist();
        System.out.println("paramId = " + request.getParameter("ref"));
        System.out.println("paramId = " + paramId);
        if (paramId != -1L) {
            // add to wishlist
            var found = false;
            for (var item : wishlist) {
                if (item.getProductId().equals(paramId)) {
                    wishlist.remove(item);
                    user.setWishlist(wishlist);
                    UserRepo.getInstance().update(user);
                    break;
                }
            }
        }

        System.out.println("wishlist = " + wishlist);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
