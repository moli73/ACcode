class LRUCache {

    class DListNode {
        int key;
        int val;
        DListNode pre;
        DListNode next;
        public DListNode (int key, int val) {
            this.key = key;
            this.val = val;
            pre = null;
            next = null;
        }
    }

    private void remove(DListNode node) {
        node.next.pre = node.pre;
        node.pre.next = node.next;

        node.next = null;
        node.pre = null;
    }

    private void append(DListNode node) {
        node.next = dummy;
        node.pre = dummy.pre;

        dummy.pre.next = node;
        dummy.pre = node;
    }
    //the tail node is the most recently used pair
    private void moveToTail(DListNode node) {
        remove(node);
        append(node);
    }

    private Map<Integer, DListNode> map;
    private DListNode dummy;//use one dummy node to record the head and tail node
    private int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        dummy = new DListNode(0, 0);
        dummy.next = dummy;
        dummy.pre = dummy;
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            DListNode node = map.get(key);
            moveToTail(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DListNode node = map.get(key);
            node.val = value;
            map.put(key, node);//key point: remember to update the HashMap
            moveToTail(node);
        } else {
            if(map.size() == capacity) {
                DListNode delNode = dummy.next;
                map.remove(delNode.key);
                remove(delNode);
            }
            DListNode newNode = new DListNode(key, value);
            append(newNode);
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
