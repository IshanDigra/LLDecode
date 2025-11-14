package CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Factory;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal.Animal;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal.Duck;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal.Tiger;

public class FactoryImpl implements Factory{

    @Override
    public Animal getAnimal(String type) {
        switch (type){
            case "Duck":
                return new Duck();

            case "Tiger" :
                return new Tiger();

            default:
                System.out.println("Animal Type Not Defined!");
                break;
        }

        return null;
    }
}
