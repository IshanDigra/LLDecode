package ConcurrencyProblems.ConsumerProducerProblem;

import java.security.PrivateKey;

public class Consumer implements Runnable{
    private  CustomQueue q ;

    public Consumer(CustomQueue q) {
        this.q = q;
    }


    @Override
    public void run() {
        for(int i = 1; i <=5; i++){
            q.removeElement();
            // simulating the consume time so that other threads could also consume.
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
