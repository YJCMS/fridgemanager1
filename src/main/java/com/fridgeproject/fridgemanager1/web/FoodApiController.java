package com.fridgeproject.fridgemanager1.web;

import java.util.List;

import com.fridgeproject.fridgemanager1.dto.FoodListResponseDto;
import com.fridgeproject.fridgemanager1.dto.FoodSaveRequestDto;
import com.fridgeproject.fridgemanager1.service.FoodService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class FoodApiController {
    private final FoodService foodService;

    @PostMapping("/api/v1/foodsave")
    public Long save(@RequestBody FoodSaveRequestDto requestDto) {
        return foodService.save(requestDto);
    }

    @GetMapping("/api/v1/foodall")
    public List<FoodListResponseDto> foodFindAll() {
        return foodService.findAll();
    }

    @PutMapping("/api/v1/food/{id}")
    public Long update(@PathVariable Long id, @RequestBody FoodSaveRequestDto requestDto) {
        return foodService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/food/{id}")
    public Long delete(@PathVariable Long id) {
        foodService.delete(id);
        return id;
    }

}
