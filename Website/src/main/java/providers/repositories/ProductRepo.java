package providers.repositories;

import managers.DatabaseManager;
import models.orm.Category;
import models.orm.Product;
import models.orm.ShoppingCart;
import models.orm.User;

import java.util.List;

public class ProductRepo extends GenericRepo<Product, Long> {
    private static volatile ProductRepo instance = null;

    private ProductRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static ProductRepo getInstance() {
        if (instance == null) {
            synchronized (ProductRepo.class) {
                if (instance == null) {
                    instance = new ProductRepo();
                }
            }
        }
        return instance;
    }


    public List<Product> findLikeName(String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findLikeName")
                        .setParameter("name", "%" + name + "%") // dammit
                        .list());
    }

    public List<Product> findByPriceRange(int min, int max) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByPriceRange")
                        .setParameter("min", min)
                        .setParameter("max", max)
                        .list());
    }

    public List<Product> findByCategory(Category category) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByCategory")
                        .setParameter("category", category)
                        .list());
    }

    // extra dammit
    public List<Product> findByCategoryPriceName(Category category, int min, int max, String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByCategory")
                        .setParameter("category", category)
                        .setParameter("min", min)
                        .setParameter("max", max)
                        .setParameter("name", "%" + name + "%") // dammit
                        .list());
    }

}
