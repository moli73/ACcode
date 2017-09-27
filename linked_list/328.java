/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode tail1 = dummy1, tail2 = dummy2;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = tail1.next;
            tail1.next = cur;
            cur = next;
            tail1 = tail1.next;
            if(cur == null) break;
            next = cur.next;
            cur.next = tail2.next;
            tail2.next = cur;
            cur = next;
            tail2 = tail2.next;
        }
        tail1.next = dummy2.next;
        return dummy1.next;
    }
}
