package Problems.MEDIUM.Cache_LRU;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRU<K,V> {
    private Node<K, V> head;
    private Node<K, V> tail;
    private Map<K,Node<K,V>> hash;
    private final int capacity ;

    public LRU(int capacity) {
        this.capacity = capacity;
        hash = new ConcurrentHashMap<>();
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }

    void remove(Node<K,V> node){
        (node.prev).next = node.next;
        (node.next).prev = node.prev;
        hash.remove(node.key);
    }

    void add(Node<K,V> node){
        hash.put(node.key, node);
        Node<K,V> temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    V get(K key) {
        if(!hash.containsKey(key)) return null;
        Node<K,V> node = hash.get(key);
        remove(node);
        add(node);
        return node.value;
    }

    void put(K key, V value) {
        Node<K,V> node = new Node<>(key,value);
        if(hash.containsKey(key)){
            hash.remove(key);
        }

        if(hash.size()==capacity){
            remove(tail.prev);
        }
        add(node);
    }
}
