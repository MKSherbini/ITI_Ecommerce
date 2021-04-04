package providers.repositories;

import managers.DatabaseManager;
import models.orm.CreditCard;
import models.orm.FakeCreditCard;
import models.orm.User;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class CreditCardRepo extends GenericRepo<CreditCard, Long> {
    private static volatile CreditCardRepo instance = null;

    private CreditCardRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CreditCardRepo getInstance() {
        if (instance == null) {
            synchronized (CreditCardRepo.class) {
                if (instance == null) {
                    instance = new CreditCardRepo();
                }
            }
        }
        return instance;
    }

    public List<CreditCard> findCardsByUser(User owner) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("CreditCard.findCardsByUser")
                        .setParameter("owner", owner)
                        .getResultList());
    }

    public Optional<CreditCard> findValidCard(String cardNumber, String cvv, Date expireDate) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<CreditCard>) session
                        .createNamedQuery("CreditCard.findValidCard")
                        .setParameter("cardNumber", cardNumber)
                        .setParameter("cvv", cvv)
                        .setParameter("expireDate", expireDate)
                        .getResultList().stream().findAny());
    }

    public boolean charge(CreditCard card, int amount) {
        if (card.getFakeCreditCard().getBalance() < amount ||
                card.getFakeCreditCard().getExpireDate().getTime() < Date.valueOf(LocalDate.now()).getTime())
            return false;

        card.getFakeCreditCard().setBalance(card.getFakeCreditCard().getBalance() - amount);
        update(card);
        return true;
    }

    public Optional<CreditCard> getUserCreditCard(User user) {
        var cards = findCardsByUser(user);
        if (cards.size() == 0) return Optional.empty();

        CreditCard defaultCard = cards.get(0); // of get the card with most money any way idc
        for (var card : cards) {
            if (card.isDefault()) {
                defaultCard = card;
                break;
            }
        }
        return Optional.of(defaultCard);
    }

}
