package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;


import com.sun.el.stream.Optional;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// todo make pagination db side

@NamedQueries({
        @NamedQuery(
                name = "Product.findMinMaxPriceLikeName",
                query = "select min(p.price*(1-(p.discountPercent/ 100.0))), max(p.price*(1-(p.discountPercent/ 100.0))) from Product p where p.name like :name or p.description like :name"),
        @NamedQuery(
                name = "Product.findMinMaxPriceCategoryName",
                query = "select min(p.price*(1-(p.discountPercent/ 100.0))), max(p.price*(1-(p.discountPercent/ 100.0))) from Product p where p.category.name in (:categories) and p.name like :name or p.description like :name"),
        @NamedQuery(
                name = "Product.findLikeName",
                query = "select p from Product p where p.name like :name or p.description like :name"),
        @NamedQuery(
                name = "Product.findByPriceRange", // todo handle discount
                query = "select p from Product p where p.price*(1-(p.discountPercent/ 100.0)) between :min and :max"),
        @NamedQuery(
                name = "Product.findByCategory",
                query = "select p from Product p where :category = p.category"),
        @NamedQuery(
                name = "Product.findByPriceName",
                query = "select p from Product p where " +
                        "p.price*(1-(p.discountPercent/ 100.0)) between :min and :max " +
                        "and (p.name like :name or p.description like :name)"),
        @NamedQuery(
                name = "Product.findByCategoryPriceName", // hope we can find a better sol
                query = "select p from Product p where :category = p.category " +
                        "and p.price*(1-(p.discountPercent/ 100.0)) between :min and :max " +
                        "and (p.name like :name or p.description like :name)"),
        @NamedQuery(
                name = "Product.findByMultiCategoryPriceName", // hope we can find a better sol
                query = "select p from Product p where p.category.name in (:categories)  " +
                        "and p.price*(1-(p.discountPercent/ 100.0)) between :min and :max " +
                        "and (p.name like :name or p.description like :name)"),
        @NamedQuery(
                name = "Product.getNewArrivals",
                query = "select p from Product p order by p.arrivalDate desc"),
})

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long productId;
    @Column(nullable = false)
    private String name;
    private int price;
    private String description;
    private int quantity;
    @Column(nullable = false)
    private String imageSrc;
    private int discountPercent;
    @Column(nullable = false)
    private Timestamp arrivalDate;

    @ManyToOne(optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
//    @ToString.Exclude
    private ProductCategory category;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, orphanRemoval = true)
    @ToString.Exclude
    private List<ProductImage> productImages;

    public Product() {
    }

    public Product(String name, int price, String description, int quantity, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.arrivalDate = new Timestamp(new Date().getTime());
        this.category = category;
    }

    public Product(String name, int price, String description, int quantity, int discountPercent, ProductCategory category, List<ProductImage> productImages) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.discountPercent = discountPercent;
        this.arrivalDate = new Timestamp(new Date().getTime());
        this.category = category;
        this.productImages = productImages;
    }

    public void setProductImages(List<String> downloadLinks){
        for(int i=0;i<downloadLinks.size();i++){
            productImages.add(new ProductImage(downloadLinks.get(i),this));
        }
    }
}

