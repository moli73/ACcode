/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        map.put(null, null);
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode cur = dummy;
        while(head != null) {
            if(map.containsKey(head)) {
                cur.next = map.get(head);
            } else {
                cur.next = new RandomListNode(head.label);
                map.put(head, cur.next);
            }
            cur = cur.next;
            if(map.containsKey(head.random)) {
                cur.random = map.get(head.random);
            } else {
                cur.random = new RandomListNode(head.random.label);
                map.put(head.random, cur.random);
            }
            head = head.next;
        }
        return dummy.next;
    }
}

//version 2;
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }

        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

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
