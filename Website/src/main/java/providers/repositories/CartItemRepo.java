package providers.repositories;

import models.orm.CartItem;

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
}
