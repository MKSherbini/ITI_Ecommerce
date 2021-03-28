package listeners;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import constants.enums.ServiceNames;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public final class ThreadLocalContext implements AutoCloseable {

    private static final ThreadLocal<ThreadLocalContext> instance = new ThreadLocal<>();

    private final HttpServletRequest request;
    private final HttpServletResponse response;

    private ThreadLocalContext(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public static ThreadLocalContext create(HttpServletRequest request, HttpServletResponse response) {
        ThreadLocalContext context = new ThreadLocalContext(request, response);
        instance.set(context);
        return context;
    }

    public static ThreadLocalContext getCurrentInstance() {
        return instance.get();
    }

    @Override
    public void close() {
        instance.remove();
    }

    public static void sendRedirect(ServiceNames service) throws IOException {
        getCurrentInstance().response.sendRedirect(UrlMappingConstants.getInstance().getServiceUrl(service));
    }

    public static void sendRedirect(PageNames page) throws IOException {
        getCurrentInstance().response.sendRedirect(UrlMappingConstants.getInstance().getControllerUrl(page));
    }

    public static void forward(PageNames page) throws IOException, ServletException {
        getCurrentInstance().request.getRequestDispatcher(UrlMappingConstants.getInstance().getControllerUrl(page)).forward(getCurrentInstance().request, getCurrentInstance().response);
    }

    public static void forward(ServiceNames service) throws IOException, ServletException {
        getCurrentInstance().request.getRequestDispatcher(UrlMappingConstants.getInstance().getServiceUrl(service)).forward(getCurrentInstance().request, getCurrentInstance().response);
    }

}