package models.dtos;


import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private double totalPrice;
    private int totalItemsCount;
    private List<CartItemDto> cartItems;
}
