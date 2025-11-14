package CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal.Animal;

public class Tiger implements Animal {

    @Override
    public void speak() {
        System.out.println("Tiger says Roar Roar!");
    }
}
