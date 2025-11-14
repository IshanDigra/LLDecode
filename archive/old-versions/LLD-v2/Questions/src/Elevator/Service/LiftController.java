package Elevator.Service;

import Elevator.Enums.Direction;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LiftController implements Runnable{
    Elevator elevator;
    PriorityQueue<Integer> minPq;
    PriorityQueue<Integer> maxPq;
    Queue<Integer> pendingReq;

    public LiftController() {
        minPq = new PriorityQueue<>();
        maxPq = new PriorityQueue<>(Collections.reverseOrder());
        pendingReq = new ArrayDeque<>();
    }

    public void setElevator(Elevator elevator){
        this.elevator = elevator;
    }

    public void addRequest(int floor, Direction dir){

        if(dir.equals(Direction.UP)){
            if(elevator.getDir().equals(Direction.UP)){
                if(floor < elevator.getCurrentFloor()){
                    pendingReq.offer(floor);
                }
                else minPq.offer(floor);
            }
            else{
                maxPq.offer(floor);
            }
        }

        else{
            if(elevator.getDir().equals(Direction.DOWN)){
                if(floor < elevator.getCurrentFloor()){
                    maxPq.offer(floor);
                }
                else pendingReq.offer(floor);
            }
            else{
                minPq.offer(floor);
            }
        }
    }

    public void run(){
        processRequests();
    }

    private void processRequests(){
        while(!minPq.isEmpty() || !maxPq.isEmpty() || !pendingReq.isEmpty()){
            completeRequests();
        }
        System.out.println("Lift has completed all the requests");

    }

    private void completeRequests(){
        if(elevator.getDir().equals(Direction.UP)){
            processUp();
            processDown();
        }
        else{
            processDown();
            processUp();
        }
    }

    private void processUp(){
        while (!minPq.isEmpty()){
            int floor = minPq.poll();
            elevator.setCurrentFloor(floor);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Elevator Stopped at floor "+ floor);
        }
        processPending(Direction.UP);
        if(!maxPq.isEmpty()){
            elevator.setDir(Direction.DOWN);
        }
    }

    private void processDown(){
        while (!maxPq.isEmpty()){
            int floor = maxPq.poll();
            elevator.setCurrentFloor(floor);
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Elevator Stopped at floor "+ floor);
        }
        processPending(Direction.DOWN);
        if(!minPq.isEmpty()){
            elevator.setDir(Direction.UP);
        }
    }

    private void processPending(Direction dir){
        if(dir.equals(Direction.UP)){
            while(!pendingReq.isEmpty()){
                minPq.offer(pendingReq.poll());
            }
        }
        else{
            while(!pendingReq.isEmpty()){
                maxPq.offer(pendingReq.poll());
            }
        }
    }
}



