package LLD_Problems.EASY.CoffeeVendingMachine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {
    private static VendingMachine instance;
    private List<COFFEE> menu;
    private Map<INGREDIENT,Integer> inventory;
    private VendingMachine(){
        menu = new ArrayList<>();
        inventory = new HashMap<>();
        initiateIngredients();
        intiateMenu();
    }

    public static synchronized VendingMachine getInstance(){
        if (instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    void displayMenu(){
        for(COFFEE coffee : menu){
            System.out.println(coffee.getName() + ": $" + coffee.getPrice());
        }
    }

    void initiateIngredients(){
        inventory.put(INGREDIENT.COFFEE, 10);
        inventory.put(INGREDIENT.WATER,10);
        inventory.put(INGREDIENT.MILK,10);
    }

    void intiateMenu(){
        // Add coffee types to the menu
        COFFEE espresso = new COFFEE(10,"Espresso");
        Map<INGREDIENT, Integer> espressoRecipe = new HashMap<>();
        espressoRecipe.put(INGREDIENT.COFFEE, 1);
        espressoRecipe.put(INGREDIENT.WATER, 2);
        espressoRecipe.put(INGREDIENT.MILK, 3);
        espresso.setRecipe(espressoRecipe);

        COFFEE latte = new COFFEE(20,"Latte");
        Map<INGREDIENT, Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(INGREDIENT.COFFEE, 1);
        latteRecipe.put(INGREDIENT.WATER, 2);
        latteRecipe.put(INGREDIENT.MILK, 5);
        latte.setRecipe(latteRecipe);
        menu.add(espresso);
        menu.add(latte);
    }

    COFFEE selectCoffee(String name){
        for(COFFEE coffee : menu){
            if(coffee.getName().equals(name)){
                System.out.println(coffee.getName() + " available");
                return coffee;
            }
        }
        System.out.println("No such coffee");
        return null;
    }

    void dispenseCoffee(COFFEE coffee, int amount){
        if(amount >= coffee.getPrice()){
            if(hasEnoughIngredients(coffee)){
                updateInventory(coffee);
                System.out.println("Dispensing " + coffee.getName() + "...");
                double change = amount - coffee.getPrice();
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }

            }
            else{
                System.out.println("Insufficient ingredients to make " + coffee.getName());
            }
        }
        else{
            System.out.println("Insufficient payment for " + coffee.getName());
        }
    }


    private boolean hasEnoughIngredients(COFFEE coffee){
        for(Map.Entry<INGREDIENT, Integer> entry : coffee.getRecipe().entrySet()){
            int requiredQuantity = entry.getValue();
            INGREDIENT ingredient = entry.getKey();
            if(inventory.get(ingredient)<requiredQuantity) return false;
        }
        return true;
    }

    private void updateInventory(COFFEE coffee){
        for(Map.Entry<INGREDIENT, Integer> entry : coffee.getRecipe().entrySet()){
            int requiredQuantity = entry.getValue();
            INGREDIENT ingredient = entry.getKey();
            int currval = inventory.get(ingredient);
            currval -= requiredQuantity;

            inventory.put(ingredient, currval);

            if(currval <= 5){
                System.out.println("Low Inventory Alert: "+ingredient);
            }
        }
    }
}
