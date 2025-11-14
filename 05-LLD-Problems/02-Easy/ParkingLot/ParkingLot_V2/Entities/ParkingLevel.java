package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.ParkingStatus;
import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingLevel {
    private final int id;
    private final Map<VehicleType, List<ParkingSpot>> spots;

    public ParkingLevel(int id, List<ParkingSpot>spots) {
        this.id = id;
        this.spots = new ConcurrentHashMap<>() ;
        spots.forEach(p->{
            List<ParkingSpot> temp = this.spots.getOrDefault(p.getType(), new ArrayList<>());
            temp.add(p);
            this.spots.put(p.getType(),temp);
        });
    }


    public List<ParkingSpot> getParkingSpots(VehicleType type){
        List<ParkingSpot> temp = spots.getOrDefault(type,new ArrayList<>());
        return temp.stream().filter(p->p.getStatus().equals(ParkingStatus.UNOCCUPIED)).collect(Collectors.toList());
    }
}
