package Elevator.Service;

import Elevator.Enums.Direction;

public class ExternalButton {
    LiftController controller;
    public ExternalButton(LiftController controller) {
        //buttonsPressed = new int[floors];
        this.controller = controller;
    }

    public void processRequest(int floor, Direction dir){
        controller.addRequest(floor, dir);
    }
}
