package filters;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;

import java.io.IOException;

@WebFilter(filterName = "ThreadLocalContextFilter", urlPatterns = "/*")
public class F7_ThreadLocalContextFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("F7_ThreadLocalContextFilter.doFilter");

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        try (ThreadLocalContext context = ThreadLocalContext.create(httpRequest, httpResponse)) {
            chain.doFilter(request, response);
        }
    }

}
