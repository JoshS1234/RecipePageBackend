package com.Site.Recipes.CustomExceptions;

public class RecipeNotFoundException extends RuntimeException{

    public RecipeNotFoundException() {
        super("No recipe was found");
    }

}
