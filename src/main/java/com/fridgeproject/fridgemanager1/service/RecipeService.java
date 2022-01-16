package com.fridgeproject.fridgemanager1.service;

import com.fridgeproject.fridgemanager1.dto.RecipeDto;
import com.fridgeproject.fridgemanager1.util.Recipe;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    public List<RecipeDto> findRecipeList() {
        return Recipe.getRecipeList();

    }
}
