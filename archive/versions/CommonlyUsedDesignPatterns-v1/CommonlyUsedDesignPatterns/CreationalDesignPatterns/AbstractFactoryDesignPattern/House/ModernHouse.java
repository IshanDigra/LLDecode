package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.House;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture.Furniture;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture.ModernFurniture;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior.Interior;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior.ModernInterior;

public class ModernHouse implements HouseFactory{
    @Override
    public Furniture getFurniture() {
        return new ModernFurniture();
    }

    @Override
    public Interior getInterior() {
        return new ModernInterior();
    }
}
