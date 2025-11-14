package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.Ingredient;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory implements Observable{
    private Map<Ingredient, Integer> ingredients ;
    private List<Observer> observers;

    public Inventory() {
        ingredients = new ConcurrentHashMap<>();
        observers = new LinkedList<>();
    }
    public void restockIngredients(Ingredient ingredient, int quantity){
        int currQuantity = ingredients.getOrDefault(ingredient, 0);
        ingredients.put(ingredient, currQuantity+quantity) ;
    }

    public boolean isAvailable(Recipe recipe){
        Map<Ingredient, Integer> requirement = recipe.getRecipe();
        for(Map.Entry<Ingredient, Integer> entry : requirement.entrySet()){
            if(ingredients.getOrDefault(entry.getKey(),0) < entry.getValue()){
                System.out.println("Insuffient Ingredients");
                return false;
            }
        }
        return true;
    }

    public Map<Ingredient, Integer> getIngredients() {
        return ingredients;
    }

    public void updateQuantity(Recipe recipe){
        Map<Ingredient, Integer> requirement = recipe.getRecipe();
        for(Map.Entry<Ingredient, Integer> entry : requirement.entrySet()){
            int currQuantity = ingredients.getOrDefault(entry.getKey(),0);
            ingredients.put(entry.getKey(), currQuantity- entry.getValue()) ;
            // notification logic to be implemented here.
            if(currQuantity- entry.getValue()<=1){
                notifyObserver(entry.getKey());
            }

        }
    }

    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }


    @Override
    public void add(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(Ingredient ingredient) {
        for(Observer observer : observers){
            observer.update(ingredient);
        }
    }
}
