package CommonlyUsedDesignPatterns.CreationalDesignPatterns.FactoryDesignPattern.Animal;

public class Duck implements Animal{

    @Override
    public void speak() {
        System.out.println("Duck says Quack Quack!");
    }
}
