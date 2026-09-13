package SystemDesign.Decorator;

public abstract class Decorator extends Component{
    protected Component cmp;

    public void setComponent(Component c){
        cmp = c;
    }

    public void doJob(){
        if(cmp !=null){
            cmp.doJob();
        }
    }
}
