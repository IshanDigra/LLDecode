package SystemDesign.Builder;

public interface IBuilder {
    void BuildBody();
    void InsertWheels();

    void InsertHeadLights();
    Product GetVehicle();
}
