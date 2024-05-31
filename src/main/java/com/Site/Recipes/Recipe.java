package com.Site.Recipes;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Recipe {
    Long id =  new Random().nextLong();
    List<String> ingredients = new ArrayList<String>();
    List<String> recipeSteps = new ArrayList<String>();
    String author;
    int rating;
    private LocalDate dateCreated = LocalDate.now();
    List<Integer> scores = new ArrayList<Integer>();

    Recipe() {
    }

    Recipe(Long id, List<String> ingredients, List<String> recipeSteps, List<Integer> scores, String author,  LocalDate dateCreated) {
        this.id=id;
        this.ingredients=ingredients;
        this.recipeSteps=recipeSteps;
        this.author=author;
        this.scores = scores;
        this.dateCreated=dateCreated;
        this.rating = 0;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<String> recipeSteps) {
        this.recipeSteps = recipeSteps;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
