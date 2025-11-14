package Meesho.Entities;

import Meesho.Enums.SlotStatus;

import java.time.LocalTime;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class Slot {
    private final String id;
    private final Doctor doctor;


    private LocalTime start;
    private LocalTime end;

    private SlotStatus status;

    private Patient patient;

    public Slot(String id, Doctor doctor, LocalTime start) {
        this.id = id;
        this.doctor = doctor;
        this.start = start;
        end = start.plusMinutes(30);;

        status = SlotStatus.AVAILABLE;
        patient = null;
    }

    public void bookSlot(Patient patient){

        if(status.equals(SlotStatus.BOOKED)){
            System.out.println("Slot is already bookeed");
            return;
        }
        this.patient = patient;
        status = SlotStatus.BOOKED;
    }

    public void freeSlot(){
        if(status.equals(SlotStatus.AVAILABLE)){
            System.out.println("Slot is already Free");
            return;
        }
        status = SlotStatus.AVAILABLE;
        patient = null;
    }

    public String getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public SlotStatus getStatus() {
        return status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id='" + id + '\'' +
                ", doctor=" + doctor.getName() +
                ", start=" + start +
                ", end=" + end +
                ", status=" + status +
       //         ", patient=" + patient.getName() +
                '}';
    }
}
