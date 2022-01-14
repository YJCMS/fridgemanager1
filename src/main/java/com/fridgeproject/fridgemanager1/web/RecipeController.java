package com.fridgeproject.fridgemanager1.web;


import com.fridgeproject.fridgemanager1.service.FoodService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class RecipeController {
// 새로 수정해야함
    private final FoodService foodService;

    @GetMapping("/recipe")
    public String recipe(Model model) {
        model.addAttribute("recipelist", foodService.findAll());
        return "market";
    }

}

