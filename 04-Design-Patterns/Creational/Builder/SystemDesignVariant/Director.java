package SystemDesign.Builder;

public class Director {
    private IBuilder myBuilder;

    public void makeVehicle(IBuilder builder){
        myBuilder = builder;
        myBuilder.BuildBody();
        myBuilder.InsertWheels();
        myBuilder.InsertHeadLights();
    }
}
