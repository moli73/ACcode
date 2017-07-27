/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(11, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode head : lists) {
            if(head != null) {
                pq.offer(head);
            }
        }

        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();

            if(cur.next != null) {
                pq.offer(cur.next);
            }

            cur.next = tail.next;
            tail.next = cur;

            tail = tail.next;
        }

        return dummy.next;
    }
}
