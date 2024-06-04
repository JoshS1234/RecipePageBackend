package com.Site.Recipes.repositories;

import com.Site.Recipes.models.Recipe;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Table(name = "recipe")
@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query(value="SELECT * FROM recipe", nativeQuery = true)
    List<Recipe> getAllRecipes();

    Recipe getRecipeById(Long id);



}