package providers.repositories;

import managers.DatabaseManager;
import models.orm.CustomerReview;
import models.orm.ShoppingCart;
import models.orm.Subscriber;
import models.orm.User;

import java.util.List;

public class SubscriberRepo extends GenericRepo<CustomerReview, Long> {
    private static volatile SubscriberRepo instance = null;

    private SubscriberRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static SubscriberRepo getInstance() {
        if (instance == null) {
            synchronized (SubscriberRepo.class) {
                if (instance == null) {
                    instance = new SubscriberRepo();
                }
            }
        }
        return instance;
    }


    public List<ShoppingCart> findReviewsByUser(Subscriber subscriber) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("CustomerReview.findReviewsByUser")
                        .setParameter("subscriber", subscriber)
                        .list());
    }

    public List<CustomerReview> findAllReviews() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session ->  session
                        .createNamedQuery("CustomerReview.findAllReviews")
                        .list());
    }


}
