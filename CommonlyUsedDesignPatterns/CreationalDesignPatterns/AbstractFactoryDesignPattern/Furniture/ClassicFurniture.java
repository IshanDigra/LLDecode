package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture;

public class ClassicFurniture implements Furniture{

    public ClassicFurniture() {
        getFurniture();
    }

    @Override
    public void getFurniture() {
        System.out.println("Classic Furniture delivered");
    }
}
