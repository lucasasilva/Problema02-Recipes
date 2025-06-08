package com.recipes.recipes.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record RecipeData(
        @JsonProperty("publisher") String publisher,
        @JsonProperty("title") String title,
        @JsonProperty("source_url") String sourceURL,
        @JsonProperty("recipe_id") String recipeID,
        @JsonProperty("image_url") String imageURL,
        @JsonProperty("social_rank") Integer socialRank,
        @JsonProperty("publisher_url") String publisherURLs) {
}
