package models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class AddedToCartDto {
    private String name;
    private int price;
    private double totalPrice;
    private int currentQuantity;
    private int addedQuantity;
    private int totalInCart;
    private String imageSrc;
}
