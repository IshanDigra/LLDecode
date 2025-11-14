package Meesho;

import Meesho.Entities.Ride;
import Meesho.Entities.User;
import Meesho.Entities.Vehicle;
import Meesho.Enums.RideStrategy;
import Meesho.Services.CarPoolService;
import Meesho.Util.Util;

import java.util.List;

public class Demo {
    public static void main(String[] args) {
        CarPoolService service = CarPoolService.getInstance();
        User us1= new User(Util.generateUserId(),"Ishan");
        User us2= new User(Util.generateUserId(), "Pallav");
        User us3= new User(Util.generateUserId(), "driver");

        service.registerUser(us1, new Vehicle("verna"));

        Ride r1 = service.offerRide(us1, "Mumbai", "Delhi", 10, 2);
        Ride r2 = service.offerRide(us3, "Mumbai", "Delhi", 5, 5);

        System.out.println("List of available Rides");
        List<Ride> rides = service.getRides(us2, "Mumbai", "Delhi", RideStrategy.SHORTEST_TIME);


        Ride ride = service.takeRide(us2, rides, RideStrategy.SHORTEST_DISTANCE);
        System.out.println(us2.getName()+" took ride"+ ride);

        service.completeRide(r1);
        service.completeRide(r2);

        System.out.println("fuel saved by each user");
        System.out.println(us1.getName()+": "+ us1.getFuelSaved());
        System.out.println(us2.getName()+": "+ us2.getFuelSaved());
        System.out.println(us3.getName()+": "+us3.getFuelSaved());

        System.out.println("Rides offered by Ishan");
        System.out.println(us1.getRidesOffered());

        System.out.println("rides taken by Pallav");
        System.out.println(us2.getRidesTaken());


    }
}
