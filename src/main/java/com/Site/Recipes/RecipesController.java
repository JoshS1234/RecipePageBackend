package com.Site.Recipes;

import com.Site.Recipes.CustomExceptions.RecipeIdAlreadyExistsException;
import com.Site.Recipes.CustomExceptions.RecipeNotFoundException;
import com.Site.Recipes.models.Recipe;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/recipes")
    void addRecipe(@RequestBody Recipe recipeToAdd) {
        System.out.println(recipeToAdd);
        recipesService.addRecipe(recipeToAdd);
    }

    //Read
    @GetMapping("/recipes/{id}")
    Recipe getRecipeById(@PathVariable Long id) {
        return recipesService.getRecipeById(id);
    }

    @GetMapping("/recipes")
    List<Recipe> getAllRecipes() {
        return recipesService.getAllRecipes();
    }


    //Update
    @PutMapping("/recipes/{id}")
    public void updateRecipe(@RequestBody Recipe recipeToUpdate, @PathVariable Long id) {
        recipeToUpdate.setId(id);
        recipesService.updateRecipeById(recipeToUpdate, id);
    }

    //Delete
    @DeleteMapping("/recipes/{id}")
    public void deleteRecipeById(@PathVariable Long id) {
        recipesService.deleteRecipeById(id);
    }

}
