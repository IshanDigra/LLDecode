package CommonlyUsedDesignPatterns.CreationalDesignPatterns.AbstractFactoryDesignPattern.Interior;

public class ClassicInterior implements Interior{
    public ClassicInterior(){
        getInterior();
    }
    @Override
    public void getInterior() {
        System.out.println("Classic Interior Delivered");
    }
}
