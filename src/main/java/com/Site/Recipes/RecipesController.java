package com.Site.Recipes;

import com.Site.Recipes.CustomExceptions.RecipeIdAlreadyExistsException;
import com.Site.Recipes.CustomExceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    //Delete


}
