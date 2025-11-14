package LLD_Problems.MEDIUM.RestaurantManagementSystem.Model;

import java.sql.Timestamp;

public class Reservation {
    private final int id;
    private Timestamp reservationDate;
    private int partySize;
    private String customerName;
    private String contactNumber;

    public Reservation(int id, Timestamp reservationDate, int partySize, String customerName, String contactNumber) {
        this.id = id;
        this.reservationDate = reservationDate;
        this.partySize = partySize;
        this.customerName = customerName;
        this.contactNumber = contactNumber;
    }


    public int getId() {
        return id;
    }

    public Timestamp getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Timestamp reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getPartySize() {
        return partySize;
    }

    public void setPartySize(int partySize) {
        this.partySize = partySize;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate=" + reservationDate +
                ", partySize=" + partySize +
                ", customerName='" + customerName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
