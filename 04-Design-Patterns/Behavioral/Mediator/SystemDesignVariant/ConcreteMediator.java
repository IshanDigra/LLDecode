package SystemDesign.Mediator;

public class ConcreteMediator extends Mediator{

    private Friend friend1;
    private Friend friend2;
    private Friend boss;

    public void setFriend1(Friend friend1) {
        this.friend1 = friend1;
    }

    public void setFriend2(Friend friend2) {
        this.friend2 = friend2;
    }

    public void setBoss(Friend boss) {
        this.boss = boss;
    }

    @Override
    public void send(Friend friend, String msg) {
        if(friend == friend1){
            friend2.notify(msg);
            boss.notify(friend1.name+ " sends message to "+ friend2.name);
        }
        else if(friend == friend2){
            friend1.notify(msg);
            boss.notify(friend2.name+ " sends message to "+ friend1.name);
        }
        else if(friend == boss){
            friend1.notify(msg);
            friend2.notify(msg);
        }
    }
}
