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
        ListNode pre = head, cur = head;
        while(cur != null) {
            while(cur != null && (cur == pre || cur.val == pre.val)) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = pre.next;
        }
        return head;
    }
}
