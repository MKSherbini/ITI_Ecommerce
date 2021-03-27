package models.dtos;


import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class ProductDto {
    private String name;
    private int price;
    private String description;
    private int quantity;
    private String imageSrc;
    private int discountPercent;
    private Timestamp arrivalDate;
    private String categoryName;

    public ProductDto() {
    }
}

