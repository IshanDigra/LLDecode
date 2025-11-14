package Problems.HARD.FoodDeliverySystem.Model;

import Problems.HARD.FoodDeliverySystem.Constant.RestaurantStatus;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Restaurant {
    private final String id;
    private final String  name;
    private final String  address;
    private List<MenuItem> menu;
    private RestaurantStatus status;

    public Restaurant(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        status = RestaurantStatus.OPEN;
        menu = new CopyOnWriteArrayList<>();
    }

    public void addItem(MenuItem item){
        menu.add(item);
    }

    public void removeItem(MenuItem item){
        menu.remove(item);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public RestaurantStatus getStatus() {
        return status;
    }

    public void setStatus(RestaurantStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                ", status=" + status +
                '}';
    }
}
