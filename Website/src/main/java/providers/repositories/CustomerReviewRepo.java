package providers.repositories;

import managers.DatabaseManager;
import models.orm.*;

import java.util.List;

public class CustomerReviewRepo extends GenericRepo<CustomerReview, Long> {
    private static volatile CustomerReviewRepo instance = null;

    private CustomerReviewRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CustomerReviewRepo getInstance() {
        if (instance == null) {
            synchronized (CustomerReviewRepo.class) {
                if (instance == null) {
                    instance = new CustomerReviewRepo();
                }
            }
        }
        return instance;
    }


    public List<CustomerReview> findReviewsBySubscriber(Subscriber subscriber) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("CustomerReview.findReviewsBySubscriber")
                        .setParameter("subscriber", subscriber)
                        .getResultList());
    }

    public List<CustomerReview> findAllReviews() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session ->  session
                        .createNamedQuery("CustomerReview.findAllReviews")
                        .getResultList());
    }


}
