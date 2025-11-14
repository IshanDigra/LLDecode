package Meesho.Entities.RideStrategy;

import Meesho.Enums.RideStrategy;

public class RideFactory {
    public RideStrategyInterface getRideStrategy(RideStrategy strategy){
        if(strategy.equals(RideStrategy.SHORTEST_DISTANCE)){
            return new ShortestDistance();
        }
        return new ShortestTime();
    }
}
