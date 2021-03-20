package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Product.findLikeName",
                query = "select p from Product p where p.name like :name or p.description like '%:name%'"),
        @NamedQuery(
                name = "Product.findByPriceRange", // todo handle discount
                query = "select p from Product p where p.price between :min and :max"),
        @NamedQuery(
                name = "Product.findByCategory",
                query = "select p from Product p where :category member of p.categories"),
        @NamedQuery(
                name = "Product.findByCategoryPriceName", // hope we can find a better sol
                query = "select p from Product p where :category member of p.categories " +
                        "and p.price between :min and :max " +
                        "and p.name like :name or p.description like :name"),
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
    private String name;
    private int price;
    private String description;
    private int quantity;
    private String imageSrc;
    private int discount;
    private Date arrivalDate;

    @ManyToMany()
    private List<Category> categories;
}

