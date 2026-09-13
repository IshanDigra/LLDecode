package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.House;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture.ClassicFurniture;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture.Furniture;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior.ClassicInterior;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior.Interior;

public class ClassicHouse implements HouseFactory{
    @Override
    public Furniture getFurniture() {
        return new ClassicFurniture();
    }

    @Override
    public Interior getInterior() {
        return new ClassicInterior();
    }
}
