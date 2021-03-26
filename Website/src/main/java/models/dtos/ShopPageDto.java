package models.dtos;

import lombok.Data;

@Data
public class ShopPageDto {
    private final int number;
    private final boolean selected;

    public ShopPageDto(int number, boolean selected) {
        this.number = number;
        this.selected = selected;
    }
}
