package Elevator.Models;

import Elevator.Enums.Direction;

public class Display {
    private int floor;
    private Direction dir;

    public Display(int floor, Direction dir) {
        this.floor = floor;
        this.dir = dir;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "Display{" +
                "floor=" + floor +
                ", dir=" + dir +
                '}';
    }
}
