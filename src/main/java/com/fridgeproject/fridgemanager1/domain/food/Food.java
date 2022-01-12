package com.fridgeproject.fridgemanager1.domain.food;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String foodName;

    @Column(length = 150, nullable = false)
    private String quantity;

    @Column(length = 150, nullable = false)
    private String expDate;

    @Builder
    public Food(String foodName, String quantity, String expDate) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public void update(String foodName, String quantity, String expDate) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.expDate = expDate;
    }

}