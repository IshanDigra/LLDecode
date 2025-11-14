package Meesho.Entities.RideStrategy;

import Meesho.Entities.Ride;
import Meesho.Enums.RideStrategy;

import java.util.List;

public interface RideStrategyInterface {
   public Ride getRide(List<Ride> rides, RideStrategy strategy);
}
