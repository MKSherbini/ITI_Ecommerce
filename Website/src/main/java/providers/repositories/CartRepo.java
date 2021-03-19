package providers.repositories;

import managers.DatabaseManager;
import models.orm.ShoppingCart;
import models.orm.User;

import java.util.List;

public class CartRepo extends GenericRepo<ShoppingCart, Long> {
    private static volatile CartRepo instance = null;

    private CartRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CartRepo getInstance() {
        if (instance == null) {
            synchronized (CartRepo.class) {
                if (instance == null) {
                    instance = new CartRepo();
                }
            }
        }
        return instance;
    }


    public List<ShoppingCart> findHistoryByUser(User user) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("ShoppingCart.findHistoryByUser")
                        .setParameter("user", user)
                        .list());
    }

    public ShoppingCart findShoppingCartByUser(User owner) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (ShoppingCart) session
                        .createNamedQuery("ShoppingCart.findShoppingCartByUser")
                        .setParameter("user", owner)
                        .getSingleResult());
    }
}
