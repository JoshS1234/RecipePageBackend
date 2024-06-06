package com.Site.Recipes;

import com.Site.Recipes.CustomExceptions.RecipeIdAlreadyExistsException;
import com.Site.Recipes.CustomExceptions.RecipeNotFoundException;
import com.Site.Recipes.models.Recipe;
import com.Site.Recipes.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipesService {

    @Autowired
    RecipeRepository recipeRepository;

    //Create
    Recipe addRecipe(Recipe recipeToAdd) {
        recipeRepository.save(recipeToAdd);
        return recipeRepository.getRecipeById(recipeToAdd.getId());
    }


    //Read
    List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    Recipe getRecipeById(Long id) {
        return recipeRepository.getRecipeById(id);
    }

    //Update
    public void updateRecipeById(Recipe recipeToUpdate, Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.save(recipeToUpdate);
        } else {
            throw new RecipeNotFoundException();
        }
    }

    public Recipe upvoteRecipeById(Long id) {
        if (recipeRepository.existsById(id)) {
            Recipe recipeToUpdate = recipeRepository.getRecipeById(id);
            recipeToUpdate.setUpvotes(recipeToUpdate.getUpvotes() + 1);
            updateRecipeById(recipeToUpdate, id);
            return getRecipeById(id);
        } else {
            throw new RecipeNotFoundException();
        }
    }

    public Recipe downvoteRecipeById(Long id) {
        if (recipeRepository.existsById(id)) {
            Recipe recipeToUpdate = recipeRepository.getRecipeById(id);
            recipeToUpdate.setDownvotes(recipeToUpdate.getDownvotes() + 1);
            updateRecipeById(recipeToUpdate, id);
            return getRecipeById(id);
        } else {
            throw new RecipeNotFoundException();
        }
    }

    //Delete
    public void deleteRecipeById(Long id) {
        if (recipeRepository.existsById(id)) {
            recipeRepository.deleteById(id);
        } else {
            throw new RecipeNotFoundException();
        }
    }


}
