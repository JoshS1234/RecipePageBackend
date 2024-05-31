package com.Site.Recipes;

import com.Site.Recipes.CustomExceptions.RecipeIdAlreadyExistsException;
import com.Site.Recipes.CustomExceptions.RecipeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class RecipesService {

    @Autowired
    RecipeRepository recipeRepository;

    //Create
    public Recipe addRecipe(Recipe recipeToAdd, Long id) {
        if (recipeRepository.getRecipeById(id) != null) {
            throw new RecipeIdAlreadyExistsException();
        }

        recipeToAdd.setId(id);
        recipeRepository.addRecipe(recipeToAdd);
        return recipeRepository.getRecipeById(id);
    }


    //Read

    public String getFirstTestData() {
        return recipeRepository.getFirstTest();
    }

    public List<String> getAllTestData() {
        return recipeRepository.getAllTests();
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    public Recipe getRecipeById(Long id) {
        Recipe recipeToReturn = recipeRepository.getRecipeById(id);
        if (recipeToReturn != null) {
            return recipeToReturn;
        } else {
            throw new RecipeNotFoundException();
        }

    }
}