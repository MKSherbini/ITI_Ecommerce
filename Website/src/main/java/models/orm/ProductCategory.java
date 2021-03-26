package models.orm;


//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.*;

import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Category.findAllNames",
                query = "select c.name from ProductCategory c order by c.name"),
        @NamedQuery(name = "Category.findByName",
                query = "select c from ProductCategory c where c.name = :name order by c.name"),
        @NamedQuery(name = "Category.findLikeName",
                query = "select c from ProductCategory c where c.name like :name order by c.name")
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

    @OneToMany(mappedBy = "category")
    @ToString.Exclude
    private List<Product> products;

    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }
}
