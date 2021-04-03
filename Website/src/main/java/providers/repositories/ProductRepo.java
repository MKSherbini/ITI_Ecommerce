package providers.repositories;

import managers.DatabaseManager;
import models.orm.ProductCategory;
import models.orm.Product;

import java.util.Arrays;
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


    public Object[] findMinMaxPriceLikeName(String name) {
        return (Object[]) DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findMinMaxPriceLikeName")
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList().stream().findAny().get());
    }

    public Object[] findMinMaxPriceCategoryName(String[] categories, String name) {
        return (Object[]) DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findMinMaxPriceCategoryName")
                        .setParameter("categories", Arrays.asList(categories))
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList().stream().findAny().get());
    }

    public List<Product> findLikeName(String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findLikeName")
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList());
    }

    public List<Product> findByPriceRange(int min, int max) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByPriceRange")
                        .setParameter("min", min)
                        .setParameter("max", max)
                        .getResultList());
    }

    public List<Product> findByCategory(ProductCategory productCategory) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByCategory")
                        .setParameter("category", productCategory)
                        .getResultList());
    }

    // extra dammit
    public List<Product> findByCategoryPriceName(ProductCategory productCategory, int min, int max, String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByCategoryPriceName")
                        .setParameter("category", productCategory)
                        .setParameter("min", min)
                        .setParameter("max", max)
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList());
    }

    // extra dammit
    public List<Product> findByPriceName(int min, int max, String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByPriceName")
                        .setParameter("min", min)
                        .setParameter("max", max)
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList());
    }

    // extra dammit
    public List<Product> findByMultiCategoryPriceName(String[] categories, int min, int max, String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.findByMultiCategoryPriceName")
                        .setParameter("categories", Arrays.asList(categories))
                        .setParameter("min", min)
                        .setParameter("max", max)
                        .setParameter("name", "%" + name + "%") // dammit
                        .getResultList());
    }

    public List<Product> findNewArrivals() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Product.getNewArrivals")
                        .setMaxResults(4)
                        .getResultList());
    }

}
