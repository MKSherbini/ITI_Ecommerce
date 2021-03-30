package models.orm;

//import jakarta.persistence.*;

import javax.persistence.*;


import lombok.*;


@NamedQueries({
        @NamedQuery(
                name = "CartItem.updateByProductLimits",
                query = "update CartItem c set c.productQuantity=c.product.quantity where c.productQuantity>c.product.quantity"),
        @NamedQuery(
                name = "CartItem.findTotalPriceByCart",
                query = "select sum(c.productQuantity*c.product.price*(1-c.product.discountPercent/100.0)) from CartItem c where c.cart = :cart"),
})

@Data
@Entity
@Table(name = "cart_items", uniqueConstraints =
@UniqueConstraint(columnNames = {"cart_shoppingCartId", "product_productId"}))

public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Setter(AccessLevel.NONE)
    private Long cartItemId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
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
