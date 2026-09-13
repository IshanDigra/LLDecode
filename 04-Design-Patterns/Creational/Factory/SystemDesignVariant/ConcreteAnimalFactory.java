package SystemDesign.Factory;

public class ConcreteAnimalFactory extends AnimalFactory{
    @Override
    public IAnimal getAnimal(String type) throws Exception{
        switch(type){
            case "Duck":
                return new Duck();
            case "Tiger":
                return new Tiger();
            default :

                throw new Exception("Animal Type: "+ type +" Cannot be instantiated");
        }


    }
}
