/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = node, cur = node.next;
        while(cur != null) {
            pre.val = cur.val;
            if(cur.next == null) {
                pre.next = null;
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
}
