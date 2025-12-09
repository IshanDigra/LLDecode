package LFUCache;

public class Node<K,V> {
    private final K key;
    private V value;
    private long freq;
    private Node<K,V> next;
    private Node<K,V> prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        freq = 0 ;
    }


    public long getFreq() {
        return freq;
    }

    public void setFreq(long freq) {
        this.freq = freq;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    public Node<K, V> getPrev() {
        return prev;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }
}
