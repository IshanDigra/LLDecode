package SystemDesign.state;

public class TV {
    private Remote state ;
    public TV(Remote state){
        this.state = state;
    }

    public void setState(Remote state){
        this.state = state;
    }
    public void pressButton(){
        state.pressSwitch(this);
    }
}
