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

/*
* Note that here we have used only one factory for ease of code.
* However, in real-world applications, we can delegate this process of object creation into various factories.
* So there could be a GetDuckObjectFactory implementation and vice versa for Tiger. In there, we could simply
* override the method GetAnimal and simply return that particular object. Apart from that,
* additional logic can also be implemented there.
 *
*
* */
