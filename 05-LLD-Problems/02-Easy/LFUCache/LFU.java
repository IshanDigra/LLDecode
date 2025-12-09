package LFUCache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class LFU<K,V>{
    private final Map<K, Node<K,V>> nodeMap;
    private final Map<Long, DLL<K,V>> freqMap;
    private final long capacity;
    private final AtomicLong minFrequency;

    public LFU(long capacity) {
        this.capacity = capacity;
        nodeMap = new ConcurrentHashMap<>();
        freqMap = new ConcurrentHashMap<>();
        minFrequency = new AtomicLong(0);
    }

    /*
    * */
    public void add(Node<K,V> node, long freq){
        // could add a check fpr curr size <= capacity
        if(nodeMap.size() >= capacity){
            System.out.println("Error: LFU Size Limit exceeding");
            return ;
        }
        if(node == null) return;
        nodeMap.put(node.getKey(), node);
        DLL<K, V> dll = freqMap.getOrDefault(freq, new DLL<>());
        dll.addNode(node);
        freqMap.put(freq, dll);
        node.setFreq(freq);
    }

    public void remove(Node<K,V>node) {
        if(nodeMap.size()==0){
            System.out.println("Error: LFU is empty, cant remove element");
            return ;
        }

        if(node == null) return;

        nodeMap.remove(node.getKey());
        DLL<K,V> dll = freqMap.get(node.getFreq());
        dll.removeNode(node);
        freqMap.put(node.getFreq(), dll);
    }

    public synchronized  V get(K key){
        if(!nodeMap.containsKey(key)){
            System.out.println("The key: "+key + " doesnt exist in the cache");
            return null;
        }
        Node<K,V> node = nodeMap.get(key);

        remove(node);
        if((node.getFreq()== minFrequency.get())&&(freqMap.get(minFrequency.get()).getSize()==0)){
            minFrequency.incrementAndGet();
        }
        node.setFreq(node.getFreq()+1);
        add(node, node.getFreq());
        return node.getValue();
    }

    public synchronized void put(K key, V value){
        Node<K,V> node = new Node<>(key, value);
        if(nodeMap.containsKey(key)){
            node = nodeMap.get(key);
            node.setValue(value);
            get(key);
            return ;
        }

        if(nodeMap.size() >= capacity){
            // remove the LFU
            remove(freqMap.get(minFrequency.get()).getFirstNode());
        }
        // add & update the minFr
        add(node,0);
    }
}
