package com.Site.Recipes.CustomExceptions;

public class RecipeIdAlreadyExistsException extends RuntimeException{

    public RecipeIdAlreadyExistsException() {
        super("A recipe with this ID already exists");
    }

}
