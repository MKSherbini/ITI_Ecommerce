package controllers;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import providers.repositories.UserRepo;

import java.io.IOException;
@WebServlet("/userDash")
public class UserDashboardController extends HttpServlet {
    private ServletConfig config ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users",UserRepo.getInstance().readAll());
        req.getRequestDispatcher(UrlMappingConstants.getInstance().getViewUrl(PageNames.USER_DASH_PAGE)).include(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init();
        this.config = config ;
    }

    @Override
    public ServletConfig getServletConfig() {
        return super.getServletConfig();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
