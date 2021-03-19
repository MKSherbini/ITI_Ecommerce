package models.orm;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long productId;
    private String name;
    private int price;
    private String description;
    private int quantity;
    private String imageSrc;
    private int discount;

    @ManyToMany()
    private List<Category> categories;
}
