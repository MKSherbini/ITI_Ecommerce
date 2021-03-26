package utilities.adapters;

import models.dtos.CategoryDto;
import models.dtos.ProductDto;
import models.orm.Product;
import models.orm.ProductCategory;

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
}
