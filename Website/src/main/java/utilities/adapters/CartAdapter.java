package utilities.adapters;

import models.dtos.CartDto;
import models.dtos.CategoryDto;
import models.orm.ProductCategory;
import models.orm.ShoppingCart;

import java.util.LinkedList;
import java.util.List;

public class CartAdapter {
    public static CartDto copyOrmToDto(ShoppingCart orm) {
        CartDto dto = new CartDto();
        dto.setTotalPrice(orm.getTotalPrice());
        dto.setCartItems(CartItemAdapter.copyOrmToDto(orm.getCartItems()));
        return dto;
    }
}
