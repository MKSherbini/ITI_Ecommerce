package providers.repositories;

import managers.DatabaseManager;
import models.orm.Product;
import models.orm.ProductCategory;

import java.util.List;
import java.util.Optional;

public class CategoryRepo extends GenericRepo<ProductCategory, Long> {
    private static volatile CategoryRepo instance = null;

    private CategoryRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static CategoryRepo getInstance() {
        if (instance == null) {
            synchronized (CategoryRepo.class) {
                if (instance == null) {
                    instance = new CategoryRepo();
                }
            }
        }
        return instance;
    }

    public List<String> findAllNames() {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Category.findAllNames")
                        .list());
    }

    public Optional<ProductCategory> findByName(String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Category.findByName")
                        .setParameter("name", name)
                        .list().stream().findAny());
    }

    public List<ProductCategory> findLikeName(String name) {
        return DatabaseManager.getInstance()
                .runTransactionWithRet(session -> session
                        .createNamedQuery("Category.findLikeName")
                        .setParameter("name", "%" + name + "%") // dammit
                        .list());
    }
}
