import java.util.*;

public class Main {
    public static void main(String[] args) {
        List l1 = new ArrayList() ;
        l1.add("i");
        l1.add("i");
        l1.add(1);

        l1.forEach(s-> System.out.println(s));
    }
}

