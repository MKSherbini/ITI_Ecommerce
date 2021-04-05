package controllers.card;

import constants.UrlMappingConstants;
import constants.enums.PageNames;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import listeners.ThreadLocalContext;
import models.dtos.CartDto;
import models.dtos.CreditCardDto;
import models.orm.User;
import providers.repositories.CartRepo;
import providers.repositories.CreditCardRepo;
import utilities.adapters.CreditCardAdapter;

import java.io.IOException;

@WebServlet("/cardBook")
public class CardBookController extends HttpServlet {

    ServletConfig myConfig;

    public void init(ServletConfig config) throws ServletException {
        myConfig = config;
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        request.setAttribute("cards", CreditCardAdapter.copyOrmToDto(CreditCardRepo.getInstance().findCardsByUser(user)));
        var orders = CartRepo.getInstance().findHistoryByUser(user);
        if (orders != null)
            request.setAttribute("ordersCount", orders.size());
        else
            request.setAttribute("ordersCount", 0);
        ThreadLocalContext.includeView(PageNames.CARD_BOOK);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
