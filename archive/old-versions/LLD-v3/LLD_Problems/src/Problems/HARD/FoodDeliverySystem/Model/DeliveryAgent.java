package Problems.HARD.FoodDeliverySystem.Model;

import Problems.HARD.FoodDeliverySystem.Constant.AgentStatus;

public class DeliveryAgent {
    private final String id;
    private final String name;
    private final String contact;
    private AgentStatus status;

    public DeliveryAgent(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        status = AgentStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public AgentStatus getStatus() {
        return status;
    }

    public void setStatus(AgentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeliveryAgent{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", status=" + status +
                '}';
    }
}
