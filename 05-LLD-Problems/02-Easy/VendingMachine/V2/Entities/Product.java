package AsishPratapProblems.EASY.VendingMachine.V2.Entities;

import AsishPratapProblems.EASY.VendingMachine.V2.Enums.ProductType;

public class Product {
    private final String id;
    private final String name;
    private final ProductType type;
    private double price;

    public Product(String id, String name, ProductType type, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ProductType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +

                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
