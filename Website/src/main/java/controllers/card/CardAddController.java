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
import models.orm.CreditCard;
import models.orm.FakeCreditCard;
import models.orm.User;
import providers.repositories.CartRepo;
import providers.repositories.CreditCardRepo;
import providers.repositories.FakeCreditCardRepo;
import providers.repositories.UserRepo;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/cardAdd")
public class CardAddController extends HttpServlet {

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
        var orders = CartRepo.getInstance().findHistoryByUser(user);
        if (orders != null)
            request.setAttribute("ordersCount", orders.size());
        else
            request.setAttribute("ordersCount", 0);

        ThreadLocalContext.includeView(PageNames.CARD_ADD);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // handle adding a card
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        var number = request.getParameter("number");
        var cvv = request.getParameter("cvv");
        var date = request.getParameter("date");
        var valid = FakeCreditCardRepo.getInstance().findValidCard(number, cvv, Date.valueOf(date));
        if (valid.isEmpty()) {
            ThreadLocalContext.sendRedirect(PageNames.CARD_ADD);
            return;
        }
        var card = valid.get();
        CreditCardRepo.getInstance().create(new CreditCard(card, user));
        ThreadLocalContext.sendRedirect(PageNames.CARD_BOOK);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
