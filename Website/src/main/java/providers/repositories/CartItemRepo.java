package providers.repositories;

public class CartItemRepo extends GenericRepo<CartItemRepo, Long> {
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
