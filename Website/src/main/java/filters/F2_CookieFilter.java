package filters;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "CookieFilter", urlPatterns = "/*")
public class F2_CookieFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //toDo
        var req = (HttpServletRequest) request;
        var res = (HttpServletResponse) response;
        PrintWriter out = res.getWriter();
        Cookie [] cookies = req.getCookies();
        System.out.println(" the cookies "+cookies);
        System.out.println("req = " + req.getParameter("openCookies"));
                String url = req.getRequestURL().toString();
                System.out.println(req.getQueryString());
                System.out.println(url);
        if(cookies == null) {
            if (req.getParameter("openCookies") == null) {
                Cookie c1 = new Cookie("CN", "CV");
                c1.setMaxAge(60 * 60 * 24);
                res.addCookie(c1);
                System.out.println("cookie is added");
                res.sendRedirect(url + "?openCookies=123");
            }else{
                out.println("Cookie is Disabled ; Please Open Cookies :) ");
                System.out.println("cookie is disabled");
               // res.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(PageNames.NOT_FOUND_404));
            }
        }
        else {
            System.out.println("cookie is enabled");
            chain.doFilter(request,response);
        }
    }
}
