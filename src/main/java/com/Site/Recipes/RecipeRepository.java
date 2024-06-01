package com.Site.Recipes;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

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

    //Create
    public void addRecipe(Recipe recipeToAdd) {
        recipeDB.add(recipeToAdd);
    }

    //Read
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

    //update
    public Recipe updateRecipeById(Recipe recipeToUpdate, Long id) {
        for (int i=0; i<recipeDB.size(); i++) {
            if (recipeDB.get(i).getId()==id) {
                recipeDB.set(i, recipeToUpdate);
                return getRecipeById(id);
            }
        }
        return null;
    }

    public Recipe addRatingForRecipe(Integer newScore, Long id) {
        Recipe recipeToUpdate;
        for (int i=0; i<recipeDB.size(); i++) {
            if (Objects.equals(recipeDB.get(i).getId(), id)) {
                recipeToUpdate=recipeDB.get(i);
                recipeToUpdate.getScores().add(newScore);
                recipeDB.set(i, recipeToUpdate);
                return recipeDB.get(i);
            }
        }
        return null;
    }

    //delete
    public boolean deleteRecipeById(Long id) {
        return recipeDB.removeIf(recipe -> Objects.equals(recipe.getId(), id));
    }


}
