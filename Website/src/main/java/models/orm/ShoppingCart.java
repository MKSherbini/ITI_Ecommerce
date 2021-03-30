package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "ShoppingCart.findHistoryByUser",
                query = "select c from ShoppingCart c where c.isHistory = true and c.owner = :user"),
        @NamedQuery(
                name = "ShoppingCart.findShoppingCartByUser",
                query = "from ShoppingCart where owner = :user and isHistory = false"),
        @NamedQuery(
                name = "ShoppingCart.findShoppingCartByDummyUser",
                query = "from ShoppingCart where dummyOwner = :dummyOwner and isHistory = false"),
        @NamedQuery(
                name = "ShoppingCart.updateDummyToUser",
                query = "update ShoppingCart c set c.dummyOwner=null, c.owner = :owner where c.dummyOwner = :dummyOwner and c.isHistory = false"),
})
@Data
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long shoppingCartId;

    private double totalPrice;
    private String paymentMethod;
    private Date orderTime;
    private Boolean isHistory;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private User owner;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private DummyUser dummyOwner;

    @OneToMany(mappedBy = "cart",
            orphanRemoval = true,
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public ShoppingCart() {
    }

    public ShoppingCart(User owner) {
        this.owner = owner;
        this.isHistory = false;
    }

    public ShoppingCart(DummyUser dummyOwner) {
        this.dummyOwner = dummyOwner;
        this.isHistory = false;
    }
}
