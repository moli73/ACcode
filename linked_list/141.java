/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast == null) {
                return false;
            } else {
                fast = fast.next;
            }
            if(fast == slow) return true;
        }
        return false;
    }
}
