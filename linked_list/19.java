/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        for(int i = 0; i < n; i++) {
            cur = cur.next;
        }
        while(cur != null) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}
