package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior;

public class ModernInterior implements  Interior{

    public ModernInterior() {
        getInterior();
    }

    @Override
    public void getInterior() {
        System.out.println("Modern Interior Delivered");
    }
}
