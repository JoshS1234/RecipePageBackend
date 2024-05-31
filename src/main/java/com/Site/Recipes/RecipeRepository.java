package com.Site.Recipes;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class RecipeRepository {

    List<String> testDB = new ArrayList<String>();
    List<Recipe> recipeDB = new ArrayList<Recipe>();


    RecipeRepository() {
        testDB.add("Hello world");
        testDB.add("It is I, the recipe API");

    }

    public void addRecipe(Recipe recipeToAdd) {
        recipeDB.add(recipeToAdd);
    }


    public String getFirstTest() {
        return testDB.get(0);
    }

    public List<String> getAllTests() {
        return testDB;
    }

    public List<Recipe> getAllRecipes() {
        return recipeDB;
    }

    public Recipe getRecipeById(Long id) {
        for (Recipe recipe: recipeDB) {
            if (Objects.equals(recipe.getId(), id)) {
                return recipe;
            }
        }
        return null;
    }



}
