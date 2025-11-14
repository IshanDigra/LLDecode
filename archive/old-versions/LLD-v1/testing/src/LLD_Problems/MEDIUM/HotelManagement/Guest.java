package LLD_Problems.MEDIUM.HotelManagement;

import java.util.UUID;

public class Guest {
    private final String id;
    private final String name;
    private String email;
    private String phone;

    public Guest(String id, String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = id;
    }

    // getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
