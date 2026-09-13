package SystemDesign.Adapter;

public class CalculatorAdapter {
    Calculator cal;
    Triangle tr ;

    public double getArea(Triangle tr){
        this.tr = tr;
        cal = new Calculator();

        Rectangle rec = new Rectangle(tr.b, 0.5* tr.h);

        return cal.getArea(rec);

    }


}
