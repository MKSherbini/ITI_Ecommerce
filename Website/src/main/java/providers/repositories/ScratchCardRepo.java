package providers.repositories;

import managers.DatabaseManager;
import models.orm.Admin;
import models.orm.ScratchCard;

import java.util.Optional;

public class ScratchCardRepo extends GenericRepo<ScratchCard, Long> {
    private static volatile ScratchCardRepo instance = null;

    private ScratchCardRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static ScratchCardRepo getInstance() {
        if (instance == null) {
            synchronized (ScratchCardRepo.class) {
                if (instance == null) {
                    instance = new ScratchCardRepo();
                }
            }
        }
        return instance;
    }

    public Optional<ScratchCard> findValidCard(String cardNumber) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<ScratchCard>) session
                        .createNamedQuery("ScratchCard.findValidCard")
                        .setParameter("cardNumber", cardNumber)
                        .stream().findAny());
    }

    public int use(ScratchCard card) {
        if (!card.isValid()) return 0;

        card.setValid(false);
        update(card);
        return card.getValue();
    }
}
