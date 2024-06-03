package com.Site.Recipes;
import jakarta.annotation.PostConstruct;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import java.io.*;
import java.time.LocalDate;
import java.util.List;

@Component
public class RecipesInitializer {
    private final RecipeRepository recipeRepository;

    @Value("classpath:recipes.json")
    private Resource resourceFile;

    @Autowired
    public RecipesInitializer(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void init() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(resourceFile.getFile())) {
            Object obj = jsonParser.parse(reader);

            JSONArray jsonArray = (JSONArray) obj;

            for (Object greeting : jsonArray) {
                JSONObject recipeJSON = (JSONObject) greeting;

                long id = (long) recipeJSON.get("id");
                String title = (String) recipeJSON.get("title");
                List<Ingredient> ingredients = (List<Ingredient>) recipeJSON.get("ingredients");
                List<String> recipeSteps = (List<String>) recipeJSON.get("recipeSteps");
                List<Integer> scores = (List<Integer>) recipeJSON.get("scores");
                String author = (String) recipeJSON.get("author");
                LocalDate dateCreated = LocalDate.parse((String) recipeJSON.get("date_created"));

                recipeRepository.addRecipe(new Recipe(id, title, ingredients, recipeSteps, scores, author, dateCreated));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}