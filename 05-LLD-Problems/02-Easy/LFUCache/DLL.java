package LFUCache;

import java.util.concurrent.atomic.AtomicLong;

public class DLL<K,V> {
    private final Node<K,V> head;
    private final Node<K,V> tail;
    private final AtomicLong size;

    public DLL() {
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.setNext(tail);
        tail.setPrev(head);
        size = new AtomicLong(0);
    }


    public synchronized void removeNode(Node<K,V> node){
        if(size.get() == 0L){
            System.out.println("The DLL is Empty");
            return ;
        }
        Node<K,V> temp1 = node.getPrev();
        Node<K,V> temp2 = node.getNext();
        temp1.setNext(temp2);
        temp2.setPrev(temp1);
        size.decrementAndGet();
    }

    // Like wise the addition of node takes place at the tail
    public synchronized void addNode(Node<K, V> node){
        Node<K,V> temp = tail.getPrev();
        temp.setNext(node);
        node.setPrev(temp);
        node.setNext(tail);
        tail.setPrev(node);
        size.incrementAndGet();
    }

    public Long getSize() {
        return size.get();
    }

    // removal of node takes place at the head for LRU
    public Node<K,V> getFirstNode(){
        return head.getNext();
    }
}
