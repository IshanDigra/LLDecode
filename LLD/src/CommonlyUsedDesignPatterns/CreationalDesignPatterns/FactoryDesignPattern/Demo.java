package CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal.Animal;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Factory.Factory;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Factory.FactoryImpl;

public class Demo {
    public static void main(String[] args) {
        Factory fact = new FactoryImpl();
        Animal duck = fact.getAnimal("Duck");
        Animal tiger = fact.getAnimal("Tiger");

        duck.speak();
        tiger.speak();

    }
}
