package Meesho.Entities;

import Meesho.Enums.BookingStatus;

import javax.print.Doc;

public class Booking {
    private final String id;
    private final Doctor doctor;
    private Patient patient;
    private Slot slot;
    private BookingStatus status;

    public Booking(String id, Doctor doctor, Patient patient, Slot slot) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        status = BookingStatus.PENDING;
    }

    public void confirmBooking(){
        status = BookingStatus.CONFIRMED;
    }

    public void cancelBooking(){

        status = BookingStatus.CANCELLED;
        slot.freeSlot();
    }

    public void completeBooking(){
        status = BookingStatus.COMPLETED;
    }

    public String getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", doctor=" + doctor.getName() +
                ", patient=" + patient.getName() +
                ", slot=" + slot.getId() +
                ", status=" + status +
                '}';
    }
}
