package Elevator.Service;

import Elevator.Enums.Direction;

public class InternalButton {
    //int[] buttonsPressed;
    LiftController controller;
    public InternalButton(LiftController controller) {
        //buttonsPressed = new int[floors];
        this.controller = controller;
    }

    public void processRequest(int button, Direction dir){
        controller.addRequest(button, dir);
    }
}
