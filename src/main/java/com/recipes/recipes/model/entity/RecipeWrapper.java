package com.recipes.recipes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record RecipeWrapper(Integer count, List<RecipeData> recipes) {
}
