package com.fridgeproject.fridgemanager1.dto;

import com.fridgeproject.fridgemanager1.domain.food.Food;

import lombok.Getter;

@Getter
public class FoodListResponseDto {
    private Long id;
    private String foodName;
    private String quantity;
    private String expDate;

    public FoodListResponseDto(Food entity) {
        this.id = entity.getId();
        this.foodName = entity.getFoodName();
        this.quantity = entity.getQuantity();
        this.expDate = entity.getExpDate();

    }
}
