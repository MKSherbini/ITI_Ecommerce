package providers.repositories;

import managers.DatabaseManager;
import models.orm.CartItem;
import models.orm.DummyUser;
import models.orm.ShoppingCart;
import models.orm.User;

public class CartItemRepo extends GenericRepo<CartItem, Long> {
    private static volatile CartItemRepo instance = null;

    private CartItemRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CartItemRepo getInstance() {
        if (instance == null) {
            synchronized (CartItemRepo.class) {
                if (instance == null) {
                    instance = new CartItemRepo();
                }
            }
        }
        return instance;
    }

    public void updateByProductLimits() {
        DatabaseManager.getInstance()
                .runTransaction(session -> session
                        .createNamedQuery("CartItem.updateByProductLimits")
                        .executeUpdate());

    }

    public double findTotalPriceByCart(ShoppingCart cart) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (double) session
                        .createNamedQuery("CartItem.findTotalPriceByCart")
                        .setParameter("cart", cart)
                        .getSingleResult());

    }

}
