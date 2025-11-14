package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.Ingredient;

public interface Observable {
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notifyObserver(Ingredient ingredient);
}
