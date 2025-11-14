package SystemDesign.Builder;

public class BuilderRunner {
    public static void main(String[] args){

        Director director = new Director();
        IBuilder carBuilder = new CarBuilder();
        IBuilder bikeBuilder = new BikeBuilder();

        Product car = new Product();
        director.makeVehicle(carBuilder);
        car = carBuilder.GetVehicle();
        car.Show();

        Product bike = new Product();
        director.makeVehicle(bikeBuilder);
        bike = bikeBuilder.GetVehicle();
        bike.Show();
    }
}
