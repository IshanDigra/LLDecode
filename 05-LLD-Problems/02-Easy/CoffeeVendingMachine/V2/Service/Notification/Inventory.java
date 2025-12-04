package V2.Service.Notification;

import V2.Entity.*;
import V2.Enum.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class Inventory  implements Observable{
    private static final Logger logger = Logger.getLogger(Inventory.class.getName());
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

    public void setIngredients(Map<Ingredient, Integer> ingredients) {
        this.ingredients = ingredients;
    }



}
