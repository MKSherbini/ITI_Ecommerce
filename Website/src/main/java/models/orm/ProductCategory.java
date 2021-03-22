package models.orm;


//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.*;

import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Category.findAllNames",
                query = "select c.name from ProductCategory c"),
        @NamedQuery(name = "Category.findByName",
                query = "select c.name from ProductCategory c where c.name = :name"),
        @NamedQuery(name = "Category.findLikeName",
                query = "select c.name from ProductCategory c where c.name like :name")
})

@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "categories")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long categoryId;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "categories")
    @ToString.Exclude
    private List<Product> products;

    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }
}
