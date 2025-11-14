package SystemDesign.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject implements ISubject{
    public List<Observer> list = new ArrayList<Observer>();
    public int flag;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
        notifyObservers();
    }

    @Override
    public void register(Observer observer) {
        list.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(int i = 0  ; i < list.size(); i++){
            list.get(i).update();
        }
    }
}
