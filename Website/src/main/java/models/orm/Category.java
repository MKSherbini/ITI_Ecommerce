package models.orm;


import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long categoryId;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;
}
