package models.dtos;


import lombok.*;
import models.orm.Product;

import java.util.List;

@Data
public class CategoryDto {
    private String name;
    private int numberOfProducts;
    private boolean selected;

    public CategoryDto() {
    }

    public CategoryDto(String name) {
        this.name = name;
    }
}
