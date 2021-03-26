package filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import managers.CookiesManager;
import models.orm.User;
import providers.repositories.CartRepo;
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

        String userInfo = CookiesManager.getInstance().readUserInfoCookie(httpRequest);
        var userSession = (User) httpRequest.getSession().getAttribute("user");
        if (userSession == null && userInfo != null) {
            //retrieving user info from cookie
            String[] splittedUserInfo = userInfo.split(":");
            String email = splittedUserInfo[0];
            String hashedPassword = splittedUserInfo[1];
            //checking email and password with database
            Optional<User> user = UserRepo.getInstance().findByEmailPassword(email, hashedPassword);
            if (user.isPresent()) {
                //adding user to session
                HttpSession session = httpRequest.getSession();
                session.setAttribute("user", user.get());
                session.setAttribute("cart",
                        CartAdapter.copyOrmToDto(CartRepo.getInstance().GetCartOrCreateOne(user.get()).get()));
            } else {
                //if user not found in db delete cookie
                CookiesManager.getInstance().deleteUserInfoCookie(httpResponse);
            }
        }
        chain.doFilter(request, response);
    }

}
