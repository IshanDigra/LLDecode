import java.lang.FunctionalInterface;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Main implements Iterable, Cloneable{
    public static void main(String[] args) {
        FunctionalTest it = ()-> {
            System.out.println("lambda testing");
        };
        it.demo();
        it.defaultdemo();
        FunctionalTest.staticdemo();
    }

    @Override
    public Iterator iterator() {
        return null;
    }

}