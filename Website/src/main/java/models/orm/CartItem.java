package models.orm;

//import jakarta.persistence.*;
import javax.persistence.*;


import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne()
    private ShoppingCart cart;

    @OneToOne
    private Product product;

    @Column(nullable = false)
    private int productQuantity;
}
