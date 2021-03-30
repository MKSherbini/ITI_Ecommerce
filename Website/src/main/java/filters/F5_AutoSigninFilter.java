package filters;

import constants.UrlMappingConstants;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import managers.CookiesManager;
import managers.DatabaseManager;
import models.orm.DummyUser;
import models.orm.ShoppingCart;
import models.orm.User;
import providers.repositories.CartItemRepo;
import providers.repositories.CartRepo;
import providers.repositories.DummyUserRepo;
import providers.repositories.UserRepo;
import utilities.adapters.CartAdapter;

import java.io.IOException;
import java.util.Optional;


@WebFilter(filterName = "AutoSigninFilter", urlPatterns = "/*")
public class F5_AutoSigninFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("F5_AutoSigninFilter.doFilter");

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;
        boolean validUrl = UrlMappingConstants.getInstance().isControllerUrl(httpRequest)
                || UrlMappingConstants.getInstance().isService(httpRequest);

        if (!validUrl) {
            chain.doFilter(request, response);
            return;
        }

        // try user auto login
        String userInfo = CookiesManager.getInstance().readUserInfoCookie(httpRequest);
        var userSession = (User) httpRequest.getSession().getAttribute("user");
        Optional<User> user;
        if (userSession == null && userInfo != null) {
            //retrieving user info from cookie
            String[] splittedUserInfo = userInfo.split(":");
            String email = splittedUserInfo[0];
            String hashedPassword = splittedUserInfo[1];
            //checking email and password with database
            user = UserRepo.getInstance().findByEmailPassword(email, hashedPassword);
            if (user.isPresent()) {
                //adding user to session
                HttpSession session = httpRequest.getSession();
                session.setAttribute("user", user.get());
                userSession = user.get();
            } else {
                //if user not found in db delete cookie
                CookiesManager.getInstance().deleteUserInfoCookie(httpResponse);
            }
        }
        CartItemRepo.getInstance().updateByProductLimits();

        if (userSession != null) {
            var cart = CartRepo.getInstance().GetCartOrCreateOne(userSession).get();
            cart.setTotalPrice(CartItemRepo.getInstance().findTotalPriceByCart(cart));
            httpRequest.getSession().setAttribute("cart",
                    CartAdapter.copyOrmToDto(cart));
        } else {
            // handle dummy user
            var dummyUserId = CookiesManager.getInstance().readDummyUserInfoCookie(httpRequest);

            if (dummyUserId.isPresent()) {
                var dummyUser = DummyUserRepo.getInstance().read(dummyUserId.get());
                if (dummyUser.isPresent()) {
                    var cart = CartRepo.getInstance().GetCartOrCreateOne(dummyUser.get()).get();
                    var cartDto = CartAdapter.copyOrmToDto(cart);
                    cart.setTotalPrice(CartItemRepo.getInstance().findTotalPriceByCart(cart));
                    httpRequest.getSession().setAttribute("cart", cartDto);
                    httpRequest.getSession().setAttribute("dummyUser", dummyUser.get());
                } else {
                    createDummyUser(httpRequest, httpResponse);
                }
            } else {
                createDummyUser(httpRequest, httpResponse);
            }
        }
        chain.doFilter(request, response);
    }

    private void createDummyUser(HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        var dummyUser = new DummyUser();
        var cart = new ShoppingCart(dummyUser);
        CartRepo.getInstance().create(cart);
        dummyUser.setCart(cart);
        DummyUserRepo.getInstance().create(dummyUser);
        cart = CartRepo.getInstance().GetCartOrCreateOne(dummyUser).get();
        var cartDto = CartAdapter.copyOrmToDto(cart);
        cart.setTotalPrice(CartItemRepo.getInstance().findTotalPriceByCart(cart));
        httpRequest.getSession().setAttribute("cart", cartDto);
        httpRequest.getSession().setAttribute("dummyUser", dummyUser);
        CookiesManager.getInstance().writeDummyUserInfoCookie(httpResponse, dummyUser.getDummyId());
    }

}
