package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.House.ClassicHouse;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.House.HouseFactory;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.House.ModernHouse;


public class Demo {
    public static void main(String[] args) {
        HouseFactory hf1 = new ClassicHouse();
        hf1.getFurniture();
        hf1.getInterior();


        HouseFactory hf2 = new ModernHouse();
        hf2.getFurniture();
        hf2.getInterior();
    }
}

/*
* Note that over here we can further delegate the process of object creation. I'm talking about the house factory, so we can further implement the factory design pattern on the kind of factory object that we'll be giving based on the input theme. Let's say you have a classic theme, then the method will give you a classic house factory. Accordingly, object creation can be orchestrated.
 *
* */
