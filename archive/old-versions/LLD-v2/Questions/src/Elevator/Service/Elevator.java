package Elevator.Service;

import Elevator.Enums.Direction;
import Elevator.Enums.State;
import Elevator.Models.Display;

/*Lift: id, direction, currentFloor, Display, InnerButtons, state,
    showDisplay(), pressButton(), Move(dir, destFloor)*/

public class Elevator {
    private final int id;
    private State state;
    private Direction dir;
    private Display display;
    private int currentFloor;
    private InternalButton buttons;

    public Elevator(int id, LiftController controller) {
        this.id = id;
        state = State.ACTIVE;
        dir = Direction.UP;
        currentFloor = 0 ;
        display = new Display(currentFloor,dir);
        buttons = new InternalButton(controller);
    }


    public void showDisplay(){
        System.out.println("Lift no. " +id+ "Currently at ");
        System.out.println(display);
    }

    public void updateDisplay(){
        display.setFloor(currentFloor);
        display.setDir(dir);
    }

    public void pressButton(int floor){
        if(floor < currentFloor){
            buttons.processRequest(floor, Direction.DOWN);
        }
        else{
            buttons.processRequest(floor, Direction.UP);
        }

    }

    public void move(int start, int end, Direction direction){
        if(direction.equals(Direction.UP)){
            for(int i = start ; i < end; i++){
                currentFloor = i ;
                dir = direction;
                updateDisplay();
                showDisplay();
            }
            showDisplay();
        }
        else{
            for(int i = start ; i >end; i--){
                currentFloor = i ;
                dir = direction;
                updateDisplay();
                showDisplay();
            }
            showDisplay();
        }
    }

    public int getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public InternalButton getButtons() {
        return buttons;
    }

    public void setButtons(InternalButton buttons) {
        this.buttons = buttons;
    }
}
