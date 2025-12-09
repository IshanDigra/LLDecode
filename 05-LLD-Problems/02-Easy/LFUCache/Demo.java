package LFUCache;

public class Demo {
    public static void main(String[] args) {
        LFU<Integer, String> lfu = new LFU<>(2L) ;
        lfu.put(1,"1");
        lfu.put(2,"2");
        System.out.println(lfu.get(1));
        lfu.put(3,"3");
        System.out.println(lfu.get(2));
        System.out.println(lfu.get(3));
        lfu.put(4,"4");
        System.out.println(lfu.get(1));
        System.out.println(lfu.get(3));
        System.out.println(lfu.get(4));

    }
}
