/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, start = head, end = head;
        while(start != null) {
            while(end != null && start.val == end.val) {
                end = end.next;
            }
            if(start.next != end) {
                pre.next = end;
            } else {
                pre = pre.next;
            }
            start = end;
        }
        return dummy.next;
    }
}
