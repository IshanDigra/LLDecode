package Elevator;

import Elevator.Enums.Direction;
import Elevator.Models.Floor;
import Elevator.Service.Elevator;
import Elevator.Service.LiftController;

public class Demo {
    public static void main(String[] args) {
        LiftController lc = new LiftController();
        Elevator el = new Elevator(1,lc);
        lc.setElevator(el);

        Floor f0 = new Floor(1, lc);
        Floor f1 = new Floor(2,lc);

        Thread th = new Thread(lc);
        th.start();
        f0.requestLift(Direction.UP);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        el.pressButton(3);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread th2 = new Thread(lc);
        th2.start();
        f1.requestLift(Direction.DOWN);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        el.pressButton(1);
    }
}
