package ConcurrencyProblems.ConsumerProducerProblem;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class CustomQueue {
    private Queue<Integer> q;
    private final int capacity;

    public CustomQueue(int capacity) {
        this.capacity = capacity;
        q = new LinkedList<>();
    }

    public synchronized void  addElement(int x){
        while(q.size()==capacity){
            System.out.println("Queue is full... waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName()+ " Added "+x);
        q.add(x);
        notifyAll();
    }

    public synchronized void removeElement(){
        while(q.isEmpty()){
            System.out.println("Queue is empty...waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        int res = q.remove();
        System.out.println(Thread.currentThread().getName()+ " Removed "+res);
        notifyAll();

    }
}
