package com.recipes.recipes.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SingleRecipe(@JsonProperty("recipe") SingleRecipeData recipe) {
}
