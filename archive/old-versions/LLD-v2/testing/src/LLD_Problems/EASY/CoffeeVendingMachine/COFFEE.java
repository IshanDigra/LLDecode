package LLD_Problems.EASY.CoffeeVendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class COFFEE {
    private int price;
    private String name;

    private Map<INGREDIENT,Integer> recipe;

    public COFFEE(int price, String name) {
        this.price = price;
        this.name = name;
        recipe = new ConcurrentHashMap<>();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<INGREDIENT, Integer> getRecipe() {
        return recipe;
    }

    public void setRecipe(Map<INGREDIENT, Integer> recipe) {
        this.recipe = recipe;
    }
}
