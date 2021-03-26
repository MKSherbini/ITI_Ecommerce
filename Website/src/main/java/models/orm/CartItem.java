package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.*;

@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long cartItemId;

    @ManyToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private ShoppingCart cart;

    @OneToOne
    private Product product;

    @Column(nullable = false)
    private int productQuantity;

    public CartItem() {
    }

    public CartItem(ShoppingCart cart, Product product) {
        this.cart = cart;
        this.product = product;
        this.productQuantity = 1;
    }
}
