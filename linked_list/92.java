/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode tail = cur;
        for(int i = m - 1; i < n; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        tail.next.next = pre;
        tail.next = cur;
        return dummy.next;
    }
}
