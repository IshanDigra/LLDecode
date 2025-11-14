package Meesho;

import Meesho.Entities.Booking;
import Meesho.Entities.Doctor;
import Meesho.Entities.Patient;
import Meesho.Entities.Slot;
import Meesho.Enums.Speciality;
import Meesho.Service.AppointmentSystem;

import java.time.LocalTime;
import java.util.List;

public class Demo {


    public static void main(String[] args) {
        AppointmentSystem system = AppointmentSystem.getInstance();
        Doctor doc1 = new Doctor("1", "ishan", Speciality.CARIOLOGIST);
        Doctor doc2 = new Doctor("2", "Dummy", Speciality.ENT);
        Patient p1 = new Patient("1", "Joy");
        Patient p2 = new Patient("2", "Sadness");
        Patient p3 = new Patient("3", "Anger");

        system.registerDoc(doc1);
        system.registerDoc(doc2);
        system.registerPatient(p1);
        system.registerPatient(p2);
        system.registerPatient(p3);
        system.addSlots(doc1, List.of(new Slot("1", doc1, LocalTime.now()),
                new Slot("2", doc1, LocalTime.now().plusMinutes(60)),
                new Slot("5", doc1, LocalTime.now().plusMinutes(120)))
        );

        system.addSlots(doc2, List.of(new Slot("3", doc2, LocalTime.now()),
                new Slot("4", doc2, LocalTime.now().plusMinutes(60))));

        List<Slot> slots1 = system.getSlots(Speciality.CARIOLOGIST);
        //System.out.println(slots1);

        List<Slot> slots2 = system.getSlots(Speciality.ENT);
        //System.out.println(slots2);

        Booking booking1 = system.bookSlot(doc1, p1, "1");
        //System.out.println(booking1);
        Booking booking2 = system.bookSlot(doc2, p1, "4");

      //  System.out.println(booking2);
        List<Slot> slots5 = system.getSlots(Speciality.CARIOLOGIST);

        system.appointmentsBooked(p1);
        system.cancelBooking(booking1);

        List<Slot> slots3 = system.getSlots(Speciality.CARIOLOGIST);

       // System.out.println(slots1);


      //  System.out.println(slots2);



    }
}
