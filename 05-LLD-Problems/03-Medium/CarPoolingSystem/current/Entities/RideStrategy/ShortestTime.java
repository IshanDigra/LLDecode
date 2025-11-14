package Meesho.Entities.RideStrategy;

import Meesho.Entities.Ride;
import Meesho.Enums.RideStrategy;

import java.util.List;

public class ShortestTime implements RideStrategyInterface{
    @Override
    public Ride getRide(List<Ride> rides, RideStrategy strategy) {
        Ride ride = rides.get(0);
        for(Ride r : rides){
            if(ride.getDuration()>r.getDuration()){
                ride = r;
            }
        }
        return ride;
    }

}
