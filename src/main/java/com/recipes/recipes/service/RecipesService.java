package com.recipes.recipes.service;

import com.recipes.recipes.model.entity.RecipeData;
import com.recipes.recipes.model.entity.RecipeWrapper;
import com.recipes.recipes.model.entity.SingleRecipe;
import com.recipes.recipes.model.entity.SingleRecipeData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;


@Service
public class RecipesService {
    private final RestTemplate restTemplate;

    public RecipesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    //URL base para ser usada nas duas consultas
    private final String URL_BASE_API = "https://forkify-api.herokuapp.com/api/";

    //consulta por conteúdo da receita
    public RecipeWrapper searchRecipes(String recipeType){
        //metodo da api consultada precisa de uma q={conteúdo da receita}, daí a concatenação
        final String URL_FINAL_API = URL_BASE_API + "search?q=" + recipeType;
        RecipeWrapper response;
        try{
            return restTemplate.getForObject(URL_FINAL_API, RecipeWrapper.class);
        }catch(HttpStatusCodeException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma receita encontrada para o parâmetro");
        }

    }

    //consulta pelo ID da receita;
    public SingleRecipe searchRecipeByID(Integer id){
        final String URL_FINAL_API = URL_BASE_API + "get?rId=" + id;
        SingleRecipe response;
        try {
           response = restTemplate.getForObject(URL_FINAL_API, SingleRecipe.class);
            return response;

        } catch (HttpStatusCodeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Receita não encontrada para este ID", e);
        }
    }
}
