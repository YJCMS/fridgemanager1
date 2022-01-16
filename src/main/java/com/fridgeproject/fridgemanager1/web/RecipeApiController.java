package com.fridgeproject.fridgemanager1.web;




import com.fridgeproject.fridgemanager1.dto.RecipeDto;
import com.fridgeproject.fridgemanager1.service.RecipeService;


import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RecipeApiController {

    private final RecipeService recipeService;

    @GetMapping("/api/v1/recipe")
    public List<RecipeDto> recipe() {
        return recipeService.findRecipeList();
    }
}
