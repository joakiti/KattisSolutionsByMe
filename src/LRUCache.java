import java.util.HashMap;

class LRUCache {

    HashMap<Integer, LinkedNode> cache;

    int capacity;
    LinkedNode head;
    LinkedNode tail;

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.get(2);
        lru.put(2,6);
        System.out.println(lru.get(1));
        lru.put(1,5);
        lru.put(1,2);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LinkedNode();
        tail = new LinkedNode();

        head.next = tail;
        tail.prev = head;

        cache = new HashMap<>();
    }

    private LinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        LinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }


    void addNode(LinkedNode v) {
        v.next = head.next;
        v.prev = head;

        head.next.prev = v;
        head.next = v;
    }

    void removeNode(LinkedNode v) {
        v.next.prev = v.prev;
        v.prev.next = v.next;
    }

    void moveToHead(LinkedNode v) {
        removeNode(v);
        addNode(v);
    }

    public int get(int key) {
        LinkedNode linkedNode = cache.get(key);
        if (linkedNode == null) {
            return -1;
        }
        else {
            moveToHead(linkedNode);
            return linkedNode.value;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //update
            cache.get(key).value = value;
            //move to head
            moveToHead(cache.get(key));
        }
        {
            if (capacity == cache.size()) {
                //remove from tail
                cache.remove(popTail().key);
            }
            //create new
            LinkedNode node = new LinkedNode();
            node.key = key;
            node.value = value;
            //move to head
            addNode(node);
            cache.put(key, node);
        }
    }

    class LinkedNode {
        int value, key;
        LinkedNode next, prev;
    }
}