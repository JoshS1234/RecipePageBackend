package com.Site.Recipes.models;

import jakarta.persistence.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String author;
    String image_url;
    private LocalDate dateCreated = LocalDate.now();
    int upvotes;
    int downvotes;
    ArrayList<Ingredient> ingredients;
    ArrayList<String> recipe_steps;

    Recipe() {
    }

    public Recipe(Long id, String title, String author, String image_url, LocalDate dateCreated, JSONArray ingredients, JSONArray recipe_steps) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.image_url = image_url;
        this.dateCreated=dateCreated;
        this.upvotes=0;
        this.downvotes=0;
//        this.ingredients=ingredients.;
//        this.recipe_steps=recipe_steps;
        for(int i=0; i<ingredients.length(); i++) {
            try {
                JSONObject obj = ingredients.getJSONObject(i);
                Ingredient ing = new Ingredient((String) obj.get("name"), (String) obj.get("amount"));
                this.ingredients.add(ing);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        for(int i=0; i<recipe_steps.length(); i++) {
            try {
                String recipe_step = recipe_steps.getString(i);
                this.recipe_steps.add(recipe_step);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public ArrayList<String> getRecipe_steps() {
        return recipe_steps;
    }

    public void setRecipe_steps(ArrayList<String> recipe_steps) {
        this.recipe_steps = recipe_steps;
    }
}
