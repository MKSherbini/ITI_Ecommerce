package models.orm;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id")
    @Setter(AccessLevel.NONE)
    private Long imageId;

    @Column(name = "download_link", unique = true, columnDefinition = "VARCHAR(750)")
    private String downloadLink;

    @ManyToOne
    @JoinColumn(name = "product",
            foreignKey = @ForeignKey(name = "productId")
    )
    @ToString.Exclude
    private Product product;

    public ProductImage(){

    }

    public ProductImage(String downloadLink,Product product){
        this.downloadLink = downloadLink;
        this.product = product;
    }

    public ProductImage(String downloadLink){
        this.downloadLink = downloadLink;
    }
}
