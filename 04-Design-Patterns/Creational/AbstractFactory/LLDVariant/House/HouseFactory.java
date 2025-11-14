package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.House;

import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture.Furniture;
import CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior.Interior;

public interface HouseFactory {
    public Furniture getFurniture();
    public Interior getInterior();
}
