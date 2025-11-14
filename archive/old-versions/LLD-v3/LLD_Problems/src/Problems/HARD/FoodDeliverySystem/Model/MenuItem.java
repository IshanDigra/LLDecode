package Problems.HARD.FoodDeliverySystem.Model;

import Problems.HARD.FoodDeliverySystem.Constant.ItemStatus;

public class MenuItem {
    private final String id;
    private final String description;
    private final String name;
    private double price;
    private ItemStatus status;

    public MenuItem(String id, String description, String name, double price) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.price = price;
        status = ItemStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
