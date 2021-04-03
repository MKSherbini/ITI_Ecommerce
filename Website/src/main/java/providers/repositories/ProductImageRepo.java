package providers.repositories;

import managers.DatabaseManager;
import models.orm.Product;
import models.orm.ProductCategory;
import models.orm.ProductImage;

import java.util.Arrays;
import java.util.List;

public class ProductImageRepo extends GenericRepo<ProductImage, Long>{
    private static volatile ProductImageRepo instance = null;

    private ProductImageRepo() {
        if (instance != null)
            throw new RuntimeException("Use getInstance(), reflection is not allowed");
    }

    public static ProductImageRepo getInstance() {
        if (instance == null) {
            synchronized (ProductImageRepo.class) {
                if (instance == null) {
                    instance = new ProductImageRepo();
                }
            }
        }
        return instance;
    }
}
