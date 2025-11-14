package Elevator.Models;

import Elevator.Enums.Direction;
import Elevator.Service.ExternalButton;
import Elevator.Service.LiftController;

public class Floor {
    private int id;
    private ExternalButton button;

    public Floor(int id, LiftController controller) {
        this.id = id;
        button = new ExternalButton(controller);
    }

    public void requestLift(Direction dir){
        button.processRequest(id,dir);
    }
}
