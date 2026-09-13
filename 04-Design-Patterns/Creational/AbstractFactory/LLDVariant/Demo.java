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
