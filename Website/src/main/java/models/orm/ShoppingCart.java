package models.orm;

import javax.persistence.*;

import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
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
}
