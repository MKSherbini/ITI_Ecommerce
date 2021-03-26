package models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class CartItemDto {
    private Long productId;
    private int productQuantity;
    private String name;
    private int price;
    private String imageSrc;
    private String categoryName;
}
