package com.Site.Recipes.models;

import jakarta.persistence.ElementCollection;

import java.io.Serializable;


public class Ingredient implements Serializable {
    public String name;
    public String amount;

    public Ingredient() {
    }


    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount=amount;
    }
}
