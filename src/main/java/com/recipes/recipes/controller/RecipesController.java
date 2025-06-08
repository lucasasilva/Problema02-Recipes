package com.recipes.recipes.controller;

import com.recipes.recipes.model.entity.RecipeData;
import com.recipes.recipes.model.entity.RecipeWrapper;
import com.recipes.recipes.model.entity.SingleRecipe;
import com.recipes.recipes.model.entity.SingleRecipeData;
import com.recipes.recipes.service.RecipesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipesController {
    private final RecipesService recipesService;
    public RecipesController(RecipesService recipesService){
        this.recipesService = recipesService;
    }
    @GetMapping("/searchAll")
    public RecipeWrapper searchRecipes(@RequestParam String  recipe){
        return recipesService.searchRecipes(recipe);
    }

    @GetMapping("/searchByID")
    public SingleRecipe searchRecipesByID(@RequestParam Integer  recipeId){
        return recipesService.searchRecipeByID(recipeId);
    }

}
