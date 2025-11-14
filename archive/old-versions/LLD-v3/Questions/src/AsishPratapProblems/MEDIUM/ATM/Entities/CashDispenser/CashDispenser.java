package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

public class CashDispenser extends Handler{

    public CashDispenser() {
        Handler h2000 = new CashDispenser2000();
        Handler h500 = new CashDispenser500();
        Handler h200 = new CashDispenser200();
        Handler h100 = new CashDispenser100();
        Handler h50 = new CashDispenser50();
        Handler h10 = new CashDispenser10();
        Handler h1 = new CashDispenser1();

        this.setNextHandler(h2000);
        h2000.setNextHandler(h500);
        h500.setNextHandler(h200);
        h200.setNextHandler(h100);
        h100.setNextHandler(h50);
        h50.setNextHandler(h10);
        h10.setNextHandler(h1);
    }

    // here we are increasing the scope.
    @Override
    public void dispenseCash(int amount) {
        if(amount > Handler.atmCash){
            System.out.println("Insufficient Balance in ATM");
            return;
        }
        nextHandler.dispenseCash(amount);
    }
}
