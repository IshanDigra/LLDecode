package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.Ingredient;

public class Admin implements Observer{

    @Override
    public void update(Ingredient ingredient) {
        System.out.println("Dear admin "+ingredient+" quantity is low. Please restock it.");
    }
}
