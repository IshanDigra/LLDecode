package ParkingLot_V3.Entities;


import ParkingLot_V3.Enums.ParkingStatus;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Util.IdGeneratorUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ParkingLevel {
    private final String id;
    private final Map<VehicleType, List<ParkingSpot>> spots;

    public ParkingLevel(List<ParkingSpot>parkingSpots) {
        this.id = IdGeneratorUtil.generateLevelId();
        this.spots = new ConcurrentHashMap<>() ;
        parkingSpots.forEach(p->{
            List<ParkingSpot> temp = spots.getOrDefault(p.getType(), new ArrayList<>());
            temp.add(p);
            this.spots.put(p.getType(),temp);
        });
    }


    public List<ParkingSpot> getParkingSpots(VehicleType type){
        List<ParkingSpot> temp = spots.getOrDefault(type,new ArrayList<>());
        return temp.stream().filter(p->p.getStatus().equals(ParkingStatus.UNOCCUPIED)).collect(Collectors.toList());
    }
}
