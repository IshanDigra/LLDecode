package LLD_Problems.MEDIUM.HotelManagement;

import LLD_Problems.MEDIUM.HotelManagement.Constants.RoomStatus;
import LLD_Problems.MEDIUM.HotelManagement.Constants.RoomType;

import java.util.UUID;

public class Room {
    private final String id;
    private final RoomType roomType;
    private double price;
    private RoomStatus status;

    public Room(String id, RoomType roomType, double price) {
        this.roomType = roomType;
        this.price = price;
        this.status = RoomStatus.AVAILABLE;
        this.id =  id;

    }

    // getters
    public String getId() {
        return id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public RoomStatus getStatus() {
        return status;
    }

    // setters

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    // business logic
    public void bookRoom(){
        if(status == RoomStatus.AVAILABLE){
            status = RoomStatus.BOOKED;
        }
        else{
            throw new IllegalArgumentException("Room is not available");
        }
    }

    public void checkIn(){
        if(status == RoomStatus.BOOKED){
            status = RoomStatus.OCCUPIED;
        }
        else{
            throw new IllegalArgumentException("Room is not booked");
        }
    }

    public void checkOut(){
        if(status == RoomStatus.OCCUPIED){
            status = RoomStatus.AVAILABLE;
        }
        else{
            throw new IllegalArgumentException("Room is not Occupied");
        }
    }
}
