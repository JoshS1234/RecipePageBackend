package com.Site.Recipes;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class RecipesInitializer {
    private final RecipeRepository recipeRepository;

    @Value("classpath:recipes.json")
    private File resourceFile;

    @Autowired
    public RecipesInitializer(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }


    @PostConstruct
    public void init() {
        List<String> ingredients = new ArrayList<>();
        ingredients.add("Chickpeas");
        ingredients.add("Soy sauce");


        List<String> recipeSteps = new ArrayList<>();
        recipeSteps.add("Cook the chickpeas");

        List<Integer> scores = new ArrayList<>();
        scores.add(3);
        scores.add(5);
        scores.add(2);


        Recipe recipe1 = new Recipe(1L, ingredients, recipeSteps, scores, "Josh", 5, LocalDate.now());
        Recipe recipe2 = new Recipe(2L, ingredients, recipeSteps, scores , "Josh", 5, LocalDate.now());
        recipeRepository.addRecipe(recipe1);
        recipeRepository.addRecipe(recipe2);
    }


}






