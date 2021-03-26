package filters;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = "/*")
public class F6_AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("F6_AuthorizationFilter.doFilter");

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        // todo check other cases

        // check if has access
        if (!UrlMappingConstants.getInstance().isPublic(httpRequest)) {
            httpResponse.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.NOT_FOUND_404));
            // todo maybe redirect to not authorized page?
            return;
        }

        chain.doFilter(request, response);
    }

}
