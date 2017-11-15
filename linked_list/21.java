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
        ListNode pre = dummy;
        ListNode p1 = l1, p2 = l2;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                pre.next = p1;
                p1 = p1.next;
            } else {
                pre.next = p2;
                p2 = p2.next;
            }
            pre = pre.next;
        }

        if(p1 == null) {
            pre.next = p2;
        }

        if(p2 == null) {
            pre.next = p1;
        }

        return dummy.next;
    }
}


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
