import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,44,6,4,2,4));
        A.forEach(v-> System.out.println(v));
    }
}