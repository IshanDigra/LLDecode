package AsishPratapProblems.EASY.TrafficControlSystem.V1.Entities;

import AsishPratapProblems.EASY.TrafficControlSystem.V1.Enum.Signal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*TrafficSignalSystem: List<Roads>
CRUD Operations, startTrafficCycle(), activateEmergencySituation(), deactivateEmergencySituation, sleep*/
public class TrafficSignal {
    private static TrafficSignal instance;
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private List<Road> roads;
    private boolean emergency;

    private TrafficSignal(){
        roads = new ArrayList<>();
        emergency = false;
    }
    public static synchronized  TrafficSignal getInstace(){
        if(instance==null){
            instance = new TrafficSignal();
        }
        return instance;
    }

    public void addRoad(Road road){
        roads.add(road);
    }
    public void remove(Road road){
        roads.remove(road);
    }

    public void startTrafficCycle(){
        scheduler.scheduleWithFixedDelay(()->currentCycle(), 0, 10, TimeUnit.SECONDS);
    }

    private void currentCycle(){
        for(Road r : roads){
            TraficLight light = r.getLight();

            sleep(light.getRedSignalDuration());
            if(emergency == true) return;
            System.out.println(r.getName()+" current signal changed from Red to Green");
            light.setCurrentSignal(Signal.GREEN);


            sleep(light.getGreenSignalDuration());
            if(emergency == true) return;
            System.out.println(r.getName()+" current signal changed from Green to Yellow");
            light.setCurrentSignal(Signal.YELLOW);

            sleep(light.getYellowSignalDuration());
            if(emergency == true) return;
            System.out.println(r.getName()+" current signal changed from Yellow to Red");
            light.setCurrentSignal(Signal.RED);
        }

    }


    public void activateEmergencySituation(Road road){
        System.out.println("Detected an emergency situation at "+road.getName()+"!!");
        emergency = true ;
        System.out.println("Setting current signal to green");
        road.getLight().setCurrentSignal(Signal.GREEN);

        for(Road r : roads){
            if(!r.equals(road)){
                System.out.println("Due to emergency keeping "+r.getName()+" signal red");
                r.getLight().setCurrentSignal(Signal.RED);
            }

        }
    }

    public void deactivateEmergencySituation(Road road){
        System.out.println("Emergency situation handled successfully. Going back to normal.");
        road.getLight().setCurrentSignal(Signal.RED);
        emergency = false;
    }


    public void sleep(long duration){
        try {
            Thread.sleep(duration*300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
