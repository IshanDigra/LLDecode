package Meesho.Service;

import Meesho.Entities.Booking;
import Meesho.Entities.Doctor;
import Meesho.Entities.Patient;
import Meesho.Entities.Slot;
import Meesho.Enums.SlotStatus;
import Meesho.Enums.Speciality;
import Meesho.Util.Util;

import javax.print.Doc;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class AppointmentSystem {
    private static AppointmentSystem instance;
    Map<String, Doctor> doctors;
    Map<String, Patient> patients;
    List<Booking> bookings;

    private AppointmentSystem() {
        doctors = new ConcurrentHashMap<>();
        patients = new ConcurrentHashMap<>();
        bookings = new CopyOnWriteArrayList<>();
    }

    public static synchronized AppointmentSystem getInstance(){
        if(instance==null){
            instance = new AppointmentSystem();
        }
        return instance;
    }


    public void registerDoc(Doctor doc){
        if(doctors.containsKey(doc.getId())){
            System.out.println("Doc is already registered");
            return ;
        }
        System.out.println("Welcome"+ doc.getName());
        doctors.put(doc.getId(), doc);
    }

    public void registerPatient(Patient patient){
        if(patients.containsKey(patient.getId())){
            System.out.println("Patient is already registered");
            return;
        }
        System.out.println("Patient "+ patient.getName()+" registered Successfully.");
        patients.put(patient.getId(), patient);
    }

    public void addSlots(Doctor doc, List<Slot> slots){
        if(!doctors.containsKey(doc.getId())){
            System.out.println("Doc is not registered");
            return ;
        }
        doc.setSlots(slots);
        System.out.println("Done Doc!");
    }

    public List<Slot> getSlots(Speciality speciality){
        List<Slot> freeSlots = new ArrayList<>();
        for(Map.Entry<String, Doctor> doc : doctors.entrySet()){
            if(doc.getValue().getSpeciality().equals(speciality)){
                System.out.println(doc.getValue().getName()+" :");
                List<Slot> slots = doc.getValue().getSlots();
                for(Slot s : slots){
                    if(s.getStatus().equals(SlotStatus.AVAILABLE)){
                        System.out.println("Slot"+s.getId()+" : "+s.getStart()+"-"+s.getEnd());
                        freeSlots.add(s);
                    }
                }
            }
        }
        return freeSlots;
    }

    public synchronized Booking bookSlot(Doctor doc, Patient pat, String slotId){
        List<Slot> slots = doc.getSlots();
        for(Slot s : slots){
            if(s.getId().equals(slotId)&& s.getStatus().equals(SlotStatus.AVAILABLE)){
                Booking bookng  = new Booking(Util.generateBookingId(),doc,pat,s);
                s.bookSlot(pat);
                bookings.add(bookng);
                System.out.println("Booking made successfully. Booking Id: "+bookng.getId());
                return bookng;
            }
        }
        System.out.println(doc.getName()+ "no available Slots");
        return null;
    }

    public void cancelBooking(Booking booking){
        if(booking == null) return;
        System.out.println("Booking Cancelled successfully. Booking Id: "+booking.getId());
        booking.cancelBooking();
    }

    public void confirmBooking(Booking booking){
        if(booking == null) return;
        booking.confirmBooking();
    }

    public void appointmentsBooked(Patient p){
        bookings.stream()
                .filter(b->b.getPatient().getId().equals(p.getId()))
                .forEach(r-> System.out.println("booking with "+ r.getDoctor().getName()+" with booking id: "+ r.getId()));
    }

}
