/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode pre = dummy;
        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    pre = l1;
                    l1 = l1.next;
                } else {
                    ListNode next = l2.next;
                    l2.next = pre.next;
                    pre.next = l2;
                    l2 = next;

                    pre = pre.next;
                }
            } else {
                if(l1 == null) {
                    pre.next = l2;
                }
                break;
            }
        }
        return dummy.next;
    }
}
