package CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Factory;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal.Animal;

public interface Factory {
    public Animal getAnimal(String type);
}
