/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast != null) {
                fast = fast.next;
            }
        }

        ListNode l2 = sortList(slow.next);
        slow.next = null;
        ListNode l1 = sortList(head);

        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l1 = l1.next;
            } else{
                ListNode next = l2.next;
                l2.next = pre.next;
                pre.next = l2;
                l2 = next;
            }
            pre = pre.next;
        }
        if(l1 == null) {
            pre.next = l2;
        }
        return dummy.next;
    }
}
