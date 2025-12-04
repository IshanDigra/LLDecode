package V2.Entity;



import V2.Enum.*;
import java.util.*;

public class Recipe {
    private final Map<Ingredient, Integer> recipe;

    public Recipe(Map<Ingredient, Integer> recipe) {
        this.recipe = recipe;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }
}
