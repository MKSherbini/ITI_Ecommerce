package models.dtos;


import lombok.Data;

import java.util.List;

@Data
public class CartDto {
    private int totalPrice;
    private List<CartItemDto> cartItems;
}
