package models.orm;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long cartItemId;

    @ManyToOne()
    private ShoppingCart cart;

    @OneToOne
    private Product product;

    @Column(nullable = false)
    private int productQuantity;
}
