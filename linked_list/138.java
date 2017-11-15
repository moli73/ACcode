one pass的解法
time O(n)
space O(n)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;

        while(cur != null) {
            if(!map.containsKey(cur)) {
                RandomListNode copy = new RandomListNode(cur.label);
                map.put(cur, copy);
            }
            pre.next = map.get(cur);

            if(cur.random != null) {   注意判断random可能为null，就不需要copy
                if(!map.containsKey(cur.random)) {
                    RandomListNode copy = new RandomListNode(cur.random.label);
                    map.put(cur.random, copy);
                }
                pre.next.random = map.get(cur.random);
            }

            pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}

tricky Solution
time O(n)
space O(1)
将原来的链表double，然后操作
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode cur = head;
        //double
        while(cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        //copy
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        //split
        RandomListNode res = head.next;
        cur = head;
        while(cur != null && cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = cur.next.next;
            cur = next;
        }
        return res;
    }
}
