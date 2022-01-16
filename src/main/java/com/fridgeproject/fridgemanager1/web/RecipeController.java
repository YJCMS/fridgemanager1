package com.fridgeproject.fridgemanager1.web;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {

    @GetMapping("/recipe")
    public String input() {
        return "recipe";
    }
}