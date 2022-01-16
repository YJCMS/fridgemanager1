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

    @PostMapping("/api/v1/senddata")
    public String sendPostData(@RequestParam(value = "data") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    @GetMapping("/api/v1/sendgetdata")
    public String sendGetData(@RequestParam(value = "data", defaultValue = "없음") String data) {
        return "당신이 입력한 데이터는? " + data;
    }

    @GetMapping("/api/v1/recipe")
    public List<RecipeDto> recipe() {
        return recipeService.findRecipeList();
    }
}
