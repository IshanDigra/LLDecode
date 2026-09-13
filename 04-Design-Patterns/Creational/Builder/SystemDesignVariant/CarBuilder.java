package SystemDesign.Builder;

public class CarBuilder implements IBuilder{
    private Product product = new Product();

    @Override
    public void BuildBody() {
        product.Add("Body of the car has been made.");
    }

    @Override
    public void InsertWheels() {
        product.Add("Four wheels has been Inserted.");
    }

    @Override
    public void InsertHeadLights() {
        product.Add("Two headlights has been Inserted.");
    }

    @Override
    public Product GetVehicle() {
        return product;
    }
}
