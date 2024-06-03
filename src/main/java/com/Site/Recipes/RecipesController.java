package com.Site.Recipes;

import com.Site.Recipes.CustomExceptions.RecipeIdAlreadyExistsException;
import com.Site.Recipes.CustomExceptions.RecipeNotFoundException;
import com.Site.Recipes.RequestClasses.ScoreAddRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RecipesController {

    @Autowired
    RecipesService recipesService;

    @ExceptionHandler
    public String handleExceptions(RecipeIdAlreadyExistsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler
    public String handleExceptions(RecipeNotFoundException exception) {
        return exception.getMessage();
    }





    //Create
    @PostMapping("/recipes/{id}")
    public Recipe addRecipe(@RequestBody Recipe recipeToAdd, @PathVariable Long id) {
        return recipesService.addRecipe(recipeToAdd, id);
    }

    //Read
    @GetMapping("/test")
    public String getTest() {
        return recipesService.getFirstTestData();

    }

    @GetMapping("/tests")
    public List<String> getAllTests() {
        return recipesService.getAllTestData();
    }

    @GetMapping("/recipes")
    public List<Recipe> getAllRecipes() {
        return recipesService.getAllRecipes();
    }

    @GetMapping("/recipes/{id}")
    public Recipe getTests(@PathVariable Long id) {
        return recipesService.getRecipeById(id);
    }


    //Update
    @PutMapping("/recipes/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipeToUpdate, @PathVariable Long id) {
        recipeToUpdate.setId(id);
        return recipesService.updateRecipeById(recipeToUpdate, id);
    }

    @PutMapping("/recipes/rating/{id}")
    public Recipe addRatingForRecipe(@RequestBody ScoreAddRequestBody requestBody, @PathVariable Long id) {
        Integer newScore=requestBody.newScore;
        return recipesService.addRatingForRecipe(newScore, id);
    }


    //Delete
    @DeleteMapping("/recipes/{id}")
    public String deleteRecipeById(@PathVariable Long id) {
        return recipesService.deleteRecipeById(id);
    }


}
