package providers.repositories;

import managers.DatabaseManager;
import models.orm.Admin;
import models.orm.FakeCreditCard;
import models.orm.ScratchCard;
import models.orm.ShoppingCart;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

public class FakeCreditCardRepo extends GenericRepo<FakeCreditCard, Long> {
    private static volatile FakeCreditCardRepo instance = null;

    private FakeCreditCardRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static FakeCreditCardRepo getInstance() {
        if (instance == null) {
            synchronized (FakeCreditCardRepo.class) {
                if (instance == null) {
                    instance = new FakeCreditCardRepo();
                }
            }
        }
        return instance;
    }

    public Optional<FakeCreditCard> findValidCard(String cardNumber, String cvv, Date expireDate) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<FakeCreditCard>) session
                        .createNamedQuery("FakeCreditCard.findValidCard")
                        .setParameter("cardNumber", cardNumber)
                        .setParameter("cvv", cvv)
                        .setParameter("expireDate", expireDate)
                        .stream().findAny());
    }

    public boolean charge(FakeCreditCard card, int amount) {
        if (card.getBalance() < amount ||
                card.getExpireDate().getTime() < Date.valueOf(LocalDate.now()).getTime())
            return false;

        card.setBalance(card.getBalance() - amount);
        update(card);
        return true;
    }
}
