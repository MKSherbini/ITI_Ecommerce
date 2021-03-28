package models.dtos;

import lombok.Data;

import java.sql.Date;

@Data
public class AddedToCartDto {
    private String name;
    private int price;
    private int totalInCart;
    private String imageSrc;
}
