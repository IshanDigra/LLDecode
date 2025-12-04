package V2.Entity;


import V2.Enum.*;
import java.util.*;

public class Coffee {
    private String description;
    private CoffeeType type;
    private Recipe recipe;
    private double price;

    public Coffee(String description, CoffeeType type, Recipe recipe, double price) {
        this.description = description;
        this.type = type;
        this.recipe = recipe;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
