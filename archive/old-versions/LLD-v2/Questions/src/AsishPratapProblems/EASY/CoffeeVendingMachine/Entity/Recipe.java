package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.Ingredient;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Recipe {
    private Map<Ingredient, Integer> recipe;

    public Recipe(Map<Ingredient, Integer> recipe) {
        this.recipe = recipe;
    }

    public Map<Ingredient, Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<Ingredient, Integer> recipe) {
        this.recipe = recipe;
    }
}
