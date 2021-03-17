package filters;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@WebFilter(filterName = "ValidPageFilter", urlPatterns = "/*")
public class F2_ValidPageFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("F2_ValidPageFilter.doFilter");

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;
        final String url = httpRequest.getRequestURI();
        final String baseUrl = httpRequest.getContextPath();

        final String resourcePath = url.substring(baseUrl.length());
        var resource = request.getServletContext().getResource(resourcePath);

        // todo idgaf lw file 5araf later
        boolean validUrl = (resource != null && resource.getProtocol().equals("file") && new File(resource.getFile()).isFile())
                || UrlMappingConstants.getInstance().isControllerUrl(httpRequest);

        if (validUrl) {
            System.out.printf("Url %s is valid\n", resourcePath);
            chain.doFilter(request, response);
        } else {
            System.out.printf("Url %s is invalid\n", resourcePath);
            httpResponse.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.NOT_FOUND_404));
        }
    }

}
