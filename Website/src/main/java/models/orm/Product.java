package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Product.findLikeName",
                query = "select p from Product p where p.name like :name or p.description like :name"),
        @NamedQuery(
                name = "Product.findByPriceRange", // todo handle discount
                query = "select p from Product p where p.price between :min and :max"),
        @NamedQuery(
                name = "Product.findByCategory",
                query = "select p from Product p where :category = p.category"),
        @NamedQuery(
                name = "Product.findByCategoryPriceName", // hope we can find a better sol
                query = "select p from Product p where :category = p.category " +
                        "and p.price between :min and :max " +
                        "and p.name like :name or p.description like :name"),
        @NamedQuery(
                name = "Product.getNewArrivals",
                query = "select p from Product p order by p.arrivalDate desc"),
})

@Data
@Entity
@jakarta.persistence.Entity
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

    @ManyToOne(optional = false)
    @ToString.Exclude
    private ProductCategory category;

    public Product() {
    }

    public Product(String name, int price, String description, int quantity, String imageSrc, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.imageSrc = imageSrc;
        this.arrivalDate = new Timestamp(new Date().getTime());
        this.category = category;
    }
}

