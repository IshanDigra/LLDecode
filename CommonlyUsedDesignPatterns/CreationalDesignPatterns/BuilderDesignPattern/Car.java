package CommonlyUsedDesignPatterns.CreationalDesignPatterns.BuilderDesignPattern;

public class Car {
    private final String engine;
    private final int wheel;
    private String color;

    private Car(CarBuilder builder) {
        engine = builder.engine;
        wheel = builder.wheel;
        color = builder.color;

    }

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheel=" + wheel +
                ", color='" + color + '\'' +
                '}';
    }

    static class CarBuilder{
        private final String engine;
        private final int wheel;
        private String color = "Black";

        public CarBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public Car build(){
            return new Car(this);
        }
    }
}
