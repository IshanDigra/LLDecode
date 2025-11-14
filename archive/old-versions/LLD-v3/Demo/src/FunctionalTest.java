@java.lang.FunctionalInterface
public interface FunctionalTest {
    public void demo();
    default void defaultdemo(){
        System.out.println("Default method called");
    }

    static void staticdemo(){
        System.out.println("Static method called");
    }

}
