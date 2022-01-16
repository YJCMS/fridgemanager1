package com.fridgeproject.fridgemanager1.domain.food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepository extends JpaRepository<Food, Long> {
    @Query("SELECT p FROM Food p ORDER BY p.expDate ASC")
    List<Food> findAllASC();
}
