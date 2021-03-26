package utilities.adapters;

import models.dtos.CartDto;
import models.dtos.CartItemDto;
import models.orm.CartItem;
import models.orm.ShoppingCart;

import java.util.LinkedList;
import java.util.List;

public class CartItemAdapter {
    public static CartItemDto copyOrmToDto(CartItem orm) {
        CartItemDto dto = new CartItemDto();
        dto.setImageSrc(orm.getProduct().getImageSrc());
        dto.setName(orm.getProduct().getName());
        dto.setPrice(orm.getProduct().getPrice() * (1 - orm.getProduct().getDiscountPercent() / 100));
        dto.setCategoryName(orm.getProduct().getCategory().getName());
        dto.setProductQuantity(orm.getProductQuantity());
        dto.setProductId(orm.getProduct().getProductId());
        return dto;
    }

    public static List<CartItemDto> copyOrmToDto(List<CartItem> orms) {
        List<CartItemDto> dtos = new LinkedList<>();
        if (orms != null)
            orms.forEach(categoryOrm -> dtos.add(copyOrmToDto(categoryOrm)));
        return dtos;
    }
}
