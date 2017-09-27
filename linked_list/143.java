/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode pre = head, slow = head, fast = head;
        while(fast != null) {
            pre = slow;
            slow = slow.next;

            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }
        pre.next = null;

        ListNode dummy = new ListNode(0);
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = dummy.next;
            dummy.next = slow;
            slow = next;
        }

        pre = head;
        ListNode cur = dummy.next;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;

            pre = pre.next.next;
        }
    }
}
