package LLD_Problems.MEDIUM.RestaurantManagementSystem.Model;

public class InventoryItem {
    private String itemName;
    private int quantity;
    private final int id ;

    public InventoryItem(int id, int quantity, String itemName) {
        this.id = id;
        this.quantity = quantity;
        this.itemName = itemName;
    }

    public void updateQuantity(int quantity){
        this.quantity += quantity;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", id=" + id +
                '}';
    }
}
