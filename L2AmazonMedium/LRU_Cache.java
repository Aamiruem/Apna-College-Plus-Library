
import java.util.*;

public class LRU_Cache {

    class Node {

        Node prev, next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    public LRU_Cache(int _capacity) {
        this.capacity = _capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            cache.remove(tail.prev.key);
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insert(node);
    }

    public static void main(String[] args) {
        LRU_Cache obj = new LRU_Cache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1)); // Output: 1
        obj.put(3, 3);
        System.out.println(obj.get(2)); // Output: -1
        obj.put(4, 4);
        System.out.println(obj.get(1)); // Output: -1
        System.out.println(obj.get(3)); // Output: 3
        System.out.println(obj.get(4)); // Output: 4
    }
}
