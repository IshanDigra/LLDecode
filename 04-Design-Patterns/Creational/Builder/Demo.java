package CommonlyUsedDesignPatterns.CreationalDesignPatterns.BuilderDesignPattern;

public class Demo {

    public static void main(String[] args) {
        Car.CarBuilder builder = new Car.CarBuilder("V8 Engine",4);
        Car car = builder.setColor("Blue").build();
        System.out.println(car);
        // builder creates a new object everytime.
        car = builder.setColor("Black").build();
        System.out.println(car);
    }


}
