package SystemDesign.Adapter;

public class Calculator {
    public Rectangle rec ;



    public double getArea(Rectangle rec){
        this.rec = rec;
        return rec.l*rec.b;
    }
}
