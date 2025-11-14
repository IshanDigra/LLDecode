package SystemDesign.Factory;

public class FactoryRunner {
    public static void main(String[] args) throws Exception {
        AnimalFactory factory = new ConcreteAnimalFactory();
        IAnimal duck = factory.getAnimal("Duck");
        duck.speak();

        IAnimal tiger = factory.getAnimal("Tiger");
        tiger.speak();

        IAnimal Gajri = factory.getAnimal("Gajri");
    }
}
