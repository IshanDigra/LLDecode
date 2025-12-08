package LRUCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRU<K,V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;
    private final Map<K,Node<K,V>> hash;
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
        hash.remove(node.getKey());
    }

    void add(Node<K,V> node){
        hash.put(node.getKey(), node);
        Node<K,V> temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public synchronized V get(K key) {
        if(!hash.containsKey(key)){
            System.out.println("Key: "+key + " is not present in the cache");
            return null;
        }
        Node<K,V> node = hash.get(key);
        remove(node);
        add(node);
        return node.getValue();
    }

    public synchronized void put(K key, V value) {
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
