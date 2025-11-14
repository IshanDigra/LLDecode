import java.util.Scanner;

public class Demo{
    public static void main(String[] args) {
        System.out.println("Please select a valid input value: ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        System.out.println(x*10);
    }
}
