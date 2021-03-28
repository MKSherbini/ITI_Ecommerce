package utilities.adapters;

import models.dtos.CategoryDto;
import models.orm.ProductCategory;

import java.util.LinkedList;
import java.util.List;

public class CategoryAdapter {
    public static CategoryDto copyOrmToDto(ProductCategory categoryOrm) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(categoryOrm.getName());
        categoryDto.setNumberOfProducts(categoryOrm.getProducts().size());
        return categoryDto;
    }

    public static List<CategoryDto> copyOrmToDto(List<ProductCategory> categoryOrms) {
        List<CategoryDto> categoryDtos = new LinkedList<>();
        if (categoryOrms != null)
            categoryOrms.forEach(categoryOrm -> categoryDtos.add(copyOrmToDto(categoryOrm)));
        return categoryDtos;
    }
}
