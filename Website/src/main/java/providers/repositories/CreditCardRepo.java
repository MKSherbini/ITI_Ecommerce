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
        if (card.getBalance() < amount ||
                card.getExpireDate().getTime() < Date.valueOf(LocalDate.now()).getTime())
            return false;

        card.setBalance(card.getBalance() - amount);
        update(card);
        return true;
    }
}
