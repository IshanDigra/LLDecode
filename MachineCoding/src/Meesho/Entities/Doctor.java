package Meesho.Entities;

import Meesho.Enums.Speciality;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Doctor {
    private final String id;
    private String name;
    private Speciality speciality;
    private List<Slot> slots;

    public Doctor(String id, String name, Speciality speciality) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        slots = new CopyOnWriteArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }
}
