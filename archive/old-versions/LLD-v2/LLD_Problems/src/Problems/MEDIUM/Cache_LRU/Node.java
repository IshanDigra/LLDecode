package Problems.MEDIUM.Cache_LRU;

public class Node<K,V> {
    K key;
    V value;

    Node<K,V> next;
    Node<K,V> prev;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}
