class LRUCache {
    class DListNode {
        int key, val;
        DListNode prev, next;
        DListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private DListNode Head = new DListNode(-1, -1), Tail = new DListNode(-1, - 1);
    private int cap = 0;
    private Map<Integer, DListNode> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        Head.next = Tail;
        Tail.prev = Head;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            update(map.get(key));
            return map.get(key).val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            map.get(key).val = value;
            update(map.get(key));
        } else {
            if(map.size() == cap) {
                map.remove(Head.next.key);
                Head.next = Head.next.next;
                Head.next.prev = Head;
            }
            DListNode node = new DListNode(key, value);
            node.prev = Tail.prev;
            Tail.prev = node;

            node.prev.next = node;
            node.next = Tail;
            map.put(key, node);
        }
    }

    public void update(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = Tail.prev;
        Tail.prev = node;

        node.prev.next = node;
        node.next = Tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
