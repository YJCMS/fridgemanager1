package com.fridgeproject.fridgemanager1.dto;

import com.fridgeproject.fridgemanager1.domain.food.Food;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FoodSaveRequestDto {
    private String foodName;
    private String quantity;
    private String expDate;

    @Builder
    public FoodSaveRequestDto(String foodName, String quantity, String expDate) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public Food toEntity() {
        return Food.builder()
                .foodName(foodName)
                .quantity(quantity)
                .expDate(expDate)
                .build();
    }
}

