package filters;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// can't just match /, as base changes
@WebFilter(filterName = "HomeRedirectFilter", urlPatterns = "/*")
public class F1_HomeRedirectFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("F1_HomeRedirectFilter.doFilter");

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        final String url = httpRequest.getRequestURI();
        final String baseUrl = httpRequest.getContextPath();

        if (url.equals(baseUrl + "/") || url.equals(baseUrl))
            httpResponse.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.HOME_PAGE));
        else {
            chain.doFilter(request, response);
        }
    }

}
