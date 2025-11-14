package CommonlyUsedDesignPatterns.CreationalDesignPatterns.SingletonDesignPattern;

public class Singleton {
    private static Singleton instance;
    private Singleton(){
        if(instance!= null){
            throw new RuntimeException("Instance has already been created");
        }
    }

    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
