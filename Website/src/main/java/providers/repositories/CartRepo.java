package providers.repositories;

import managers.DatabaseManager;
import models.orm.*;

import java.util.List;
import java.util.Optional;

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

    public Optional<ShoppingCart> findShoppingCartByUser(User owner) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<ShoppingCart>) session
                        .createNamedQuery("ShoppingCart.findShoppingCartByUser")
                        .setParameter("user", owner)
                        .stream().findAny());
    }

    public Optional<ShoppingCart> findShoppingCartByDummyUser(DummyUser dummyOwner) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> (Optional<ShoppingCart>) session
                        .createNamedQuery("ShoppingCart.findShoppingCartByDummyUser")
                        .setParameter("dummyOwner", dummyOwner)
                        .stream().findAny());
    }

    public void updateDummyToUser(DummyUser dummyOwner, User owner) {
        DatabaseManager.getInstance()
                .runTransaction(session -> session
                        .createNamedQuery("ShoppingCart.updateDummyToUser")
                        .setParameter("dummyOwner", dummyOwner)
                        .setParameter("owner", owner)
                        .executeUpdate());
    }

    private Optional<ShoppingCart> addToShoppingCart(Product product, Optional<ShoppingCart> cart) {
        // cart logic
        var cartItems = cart.get().getCartItems();
        Optional<CartItem> currentCartItem = Optional.empty();
        if (cartItems != null)
            currentCartItem = cartItems.stream()
                    .filter(cartItem -> cartItem.getProduct().getProductId().equals(product.getProductId()))
                    .findAny();
        CartItemRepo cartItemRepo = CartItemRepo.getInstance();
        if (currentCartItem.isEmpty()) {
            var newItem = new CartItem(cart.get(), product);
            cartItemRepo.create(newItem);
        } else {
            currentCartItem.get().setProductQuantity(currentCartItem.get().getProductQuantity() + 1);
            cartItemRepo.update(currentCartItem.get());
        }

        // update price
        cart.get().setTotalPrice((int) (cart.get().getTotalPrice() + product.getPrice() * (1 - product.getDiscountPercent() / 100.0)));
        update(cart.get());
        DatabaseManager.getInstance().flush();

        return cart;
    }

    private Optional<ShoppingCart> removeFromShoppingCart(Product product, Optional<ShoppingCart> cart) {
        // cart logic
        var cartItems = cart.get().getCartItems();
        Optional<CartItem> currentCartItem = Optional.empty();
        if (cartItems != null)
            currentCartItem = cartItems.stream()
                    .filter(cartItem -> cartItem.getProduct().getProductId().equals(product.getProductId()))
                    .findAny();
        CartItemRepo cartItemRepo = CartItemRepo.getInstance();
        if (currentCartItem.isPresent()) {
            currentCartItem.get().setProductQuantity(currentCartItem.get().getProductQuantity() - 1);
            if (currentCartItem.get().getProductQuantity() >= 1) {
                cartItemRepo.update(currentCartItem.get());
            } else {
                cartItemRepo.delete(currentCartItem.get());
                cart.get().getCartItems().remove(currentCartItem.get());
                DatabaseManager.getInstance().flush();
            }

            // update price
            cart.get().setTotalPrice((int) Math.max(0, cart.get().getTotalPrice() - product.getPrice() * (1 - product.getDiscountPercent() / 100.0)));
            update(cart.get());
            DatabaseManager.getInstance().flush();
        }

        return cart;
    }

    public Optional<ShoppingCart> addProduct(User user, Product product) {
        var cart = GetCartOrCreateOne(user);
        if (cart.isEmpty()) return Optional.empty();

        return addToShoppingCart(product, cart);
    }

    public Optional<ShoppingCart> removeProduct(User user, Product product) {
        var cart = GetCartOrCreateOne(user);
        if (cart.isEmpty()) return Optional.empty();

        return removeFromShoppingCart(product, cart);
    }

    public Optional<ShoppingCart> GetCartOrCreateOne(User user) {
        var cart = findShoppingCartByUser(user);
        if (cart.isEmpty()) {
            create(new ShoppingCart(user));
        }
        cart = findShoppingCartByUser(user);
        if (cart.isEmpty()) return Optional.empty();
        return cart;
    }

    public Optional<ShoppingCart> GetCartOrCreateOne(DummyUser user) {
        var cart = findShoppingCartByDummyUser(user);
        if (cart.isEmpty()) {
            create(new ShoppingCart(user));
        }
        cart = findShoppingCartByDummyUser(user);
        if (cart.isEmpty()) return Optional.empty();
        return cart;
    }

    public Optional<ShoppingCart> addProduct(DummyUser user, Product product) {
        var cart = GetCartOrCreateOne(user);
        if (cart.isEmpty()) return Optional.empty();

        return addToShoppingCart(product, cart);
    }

    public Optional<ShoppingCart> removeProduct(DummyUser user, Product product) {
        var cart = GetCartOrCreateOne(user);
        if (cart.isEmpty()) return Optional.empty();

        return removeFromShoppingCart(product, cart);
    }
}
