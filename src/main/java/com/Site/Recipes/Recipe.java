package com.Site.Recipes;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Recipe {
    Long id =  new Random().nextLong();
    String title;
    List<Ingredient> ingredients = new ArrayList<Ingredient>();
    List<String> recipeSteps = new ArrayList<String>();
    String author;
    String imageUrl;
    double rating;
    private LocalDate dateCreated = LocalDate.now();
    List<Integer> scores = new ArrayList<Integer>();

    Recipe() {
    }

    public Recipe(Long id, String title, List<Ingredient> ingredients, List<String> recipeSteps, List<Integer> scores, String author, String imageUrl, LocalDate dateCreated) {
        this.id=id;
        this.title=title;
        this.ingredients=ingredients;
        this.recipeSteps=recipeSteps;
        this.author=author;
        this.scores = scores;
        this.imageUrl = imageUrl;
        this.dateCreated=dateCreated;
        this.rating = 0;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(double rating) {
        this.rating = rating;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
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

    public double getRating() {
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

    public double calculateRating() {
        double total = 0;
        for(Integer score : scores) {
            total+=score;
        }
        return Math.round(total/scores.size());
    }
}
