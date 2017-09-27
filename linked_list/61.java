/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode pre = null, cur = head;
        while(cur != null) {
            pre = cur;
            cur = cur.next;
            len++;
        }

        pre.next = head;
        k %= len;
        k = len - k;
        cur = head;
        for(int i = 0; i < k; i++) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = null;
        return cur;
    }
}
