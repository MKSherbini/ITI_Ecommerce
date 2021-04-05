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
import models.orm.User;
import providers.repositories.CartRepo;
import providers.repositories.CreditCardRepo;
import providers.repositories.FakeCreditCardRepo;
import providers.repositories.UserRepo;
import utilities.SafeConverter;
import utilities.adapters.CreditCardAdapter;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/cardEdit")
public class CardEditController extends HttpServlet {

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

        var cardIdS = request.getParameter("card");
        if (cardIdS == null) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        var cardId = SafeConverter.safeLongParse(cardIdS, -1L);

        var valid = CreditCardRepo.getInstance().read(cardId);
        if (valid.isEmpty()) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        var card = valid.get();
        request.setAttribute("ordersCount", CartRepo.getInstance().findHistoryByUser(user).size());
        request.setAttribute("card", CreditCardAdapter.copyOrmToDto(card));
        ThreadLocalContext.includeView(PageNames.CARD_EDIT);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // handle editing a card
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        var cardIdS = request.getParameter("card");
        if (cardIdS == null) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        var cardId = SafeConverter.safeLongParse(cardIdS, -1L);

        var valid = CreditCardRepo.getInstance().read(cardId);
        if (valid.isEmpty()) {
            ThreadLocalContext.sendRedirect(PageNames.NOT_FOUND_404);
            return;
        }
        var card = valid.get();
        CreditCardRepo.getInstance().delete(card);
        ThreadLocalContext.sendRedirect(PageNames.CARD_BOOK);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
