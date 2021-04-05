package providers.repositories;

import managers.DatabaseManager;
import models.orm.CustomerMessage;
import models.orm.CustomerReview;
import models.orm.ShoppingCart;
import models.orm.Subscriber;

import java.util.List;

public class CustomerMessageRepo extends GenericRepo<CustomerMessage, Long> {
    private static volatile CustomerMessageRepo instance = null;

    private CustomerMessageRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CustomerMessageRepo getInstance() {
        if (instance == null) {
            synchronized (CustomerMessageRepo.class) {
                if (instance == null) {
                    instance = new CustomerMessageRepo();
                }
            }
        }
        return instance;
    }


    public List<CustomerMessage> findMessageBySubscriber(Subscriber subscriber) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("CustomerMessage.findMessageBySubscriber")
                        .setParameter("subscriber", subscriber)
                        .getResultList());
    }

    public List<CustomerMessage> findAllReviews() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session ->  session
                        .createNamedQuery("CustomerMessage.findAllMessages")
                        .getResultList());
    }


}
