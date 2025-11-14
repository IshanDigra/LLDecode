package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Furniture;

public class ModernFurniture implements Furniture{

    public ModernFurniture(){
        getFurniture();
    }
    @Override
    public void getFurniture() {
        System.out.println("Modern Furniture Delivered");
    }
}
