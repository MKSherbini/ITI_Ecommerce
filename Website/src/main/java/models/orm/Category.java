package models.orm;


//import jakarta.persistence.*;
import javax.persistence.*;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long categoryId;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;
}
