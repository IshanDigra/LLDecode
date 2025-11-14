package CommonlyUsedDesignPatterns.CreationalDesignPatterns.SingletonDesignPattern;

import java.lang.reflect.Constructor;

public class Demo {
    public static void main(String[] args) {
        Singleton A = Singleton.getInstance();
        Singleton B = Singleton.getInstance();

        System.out.println(A.hashCode());
        System.out.println(B.hashCode());

        try{
            Class c = Class.forName("CommonlyUsedDesignPatterns.CreationalDesignPatterns.SingletonDesignPattern.Singleton");
            Constructor<?> cons = c.getDeclaredConstructor();
            cons.setAccessible(true);
            Object o = cons.newInstance();
            System.out.println(o.hashCode());
        }
        catch (Exception e){
            System.err.println("You cannot break singleton");
        }

    }
}
