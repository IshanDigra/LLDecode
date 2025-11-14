package SystemDesign.Factory;

public abstract class AnimalFactory {
    public abstract IAnimal getAnimal(String type) throws Exception;
}
