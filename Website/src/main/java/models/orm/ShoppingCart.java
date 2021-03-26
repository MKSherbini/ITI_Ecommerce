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
                name = "ShoppingCart.findHistoryByUser",
                query = "select c from ShoppingCart c where c.isHistory = true and c.owner = :user"),
        @NamedQuery(
                name = "ShoppingCart.findShoppingCartByUser",
                query = "from ShoppingCart where owner = :user and isHistory = false"),
})
@Data
@Entity
@jakarta.persistence.Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long shoppingCartId;

    private int totalPrice;
    private String paymentMethod;
    private Date orderTime;
    private Boolean isHistory;

    @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "cart",
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public ShoppingCart() {
    }

    public ShoppingCart(User owner) {
        this.owner = owner;
        this.isHistory = false;
    }
}
