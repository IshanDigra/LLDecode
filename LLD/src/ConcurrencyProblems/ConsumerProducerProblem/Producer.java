package ConcurrencyProblems.ConsumerProducerProblem;

public class Producer implements Runnable{
    private  CustomQueue q ;

    public Producer(CustomQueue q) {
        this.q = q;
    }


    @Override
    public void run() {
        for(int i = 1; i <=5; i++){
            q.addElement(i);
        }
    }
}
