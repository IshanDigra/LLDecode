package CommonlyUsedDesignPatterns.StructuralDesignPatterns.FacadeDesignPattern;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        System.out.println("please input an action (Music or Video): ");
        Scanner sc = new Scanner(System.in);
        String action = sc.nextLine();
        facade.play(action.toLowerCase());
    }


}
