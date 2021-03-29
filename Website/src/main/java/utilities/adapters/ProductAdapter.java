package utilities.adapters;

import models.dtos.AddedToCartDto;
import models.dtos.ProductDto;
import models.orm.CartItem;
import models.orm.Product;
import models.orm.ShoppingCart;

import java.util.LinkedList;
import java.util.List;

public class ProductAdapter {
    public static ProductDto copyOrmToDto(Product productOrm) {
        var productDto = new ProductDto();
        productDto.setName(productOrm.getName());
        productDto.setDescription(productOrm.getDescription());
        productDto.setArrivalDate(productOrm.getArrivalDate());
        productDto.setCategoryName(productOrm.getCategory().getName());
        productDto.setPrice(productOrm.getPrice());
        productDto.setDiscountPercent(productOrm.getDiscountPercent());
        productDto.setImageSrc(productOrm.getImageSrc());
        productDto.setQuantity(productOrm.getQuantity());
        return productDto;
    }

    public static List<ProductDto> copyOrmToDto(List<Product> productOrms) {
        List<ProductDto> productDtos = new LinkedList<>();
        if (productOrms != null)
            productOrms.forEach(categoryOrm -> productDtos.add(copyOrmToDto(categoryOrm)));
        return productDtos;
    }

    public static AddedToCartDto copyOrmToCartDto(Product productOrm, ShoppingCart cart) {
        var productDto = new AddedToCartDto();
        var cartItems = cart.getCartItems();
        productDto.setName(productOrm.getName());
        productDto.setPrice((int) (productOrm.getPrice() * (1 - productOrm.getDiscountPercent() / 100.0)));
        productDto.setTotalPrice(cart.getTotalPrice());
        productDto.setImageSrc(productOrm.getImageSrc());

        if (cartItems.size() > 0)
            productDto.setTotalInCart(cartItems.stream().mapToInt(CartItem::getProductQuantity).sum());

        cartItems.stream().filter(item -> item.getProduct().getProductId().equals(productOrm.getProductId()))
                .findAny().ifPresent(item -> productDto.setCurrentQuantity(item.getProductQuantity()));

        return productDto;
    }


}
