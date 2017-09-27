/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode tail1 = dummy1, tail2 = dummy2;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            if(cur.val < x) {
                cur.next = tail1.next;
                tail1.next = cur;
                tail1 = cur;
            } else {
                cur.next = tail2.next;
                tail2.next = cur;
                tail2 = cur;
            }
            cur = next;
        }
        tail1.next = dummy2.next;
        return dummy1.next;
    }
}
