package SystemDesign.Builder;

public class BikeBuilder implements IBuilder{
    private Product product = new Product();
    @Override
    public void BuildBody() {
        product.Add("Body of the Bike has been made.");
    }

    @Override
    public void InsertWheels() {
        product.Add("Two wheels has been Inserted.");
    }

    @Override
    public void InsertHeadLights() {
        product.Add("One headlights has been Inserted.");
    }

    @Override
    public Product GetVehicle() {
        return product;
    }
}
