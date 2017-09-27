/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode front = dummy;
        ListNode back = dummy;
        ListNode cur = head;
        while(cur != null) {
            front = back;
            for(int i = 0; i < 2; i++) {
                if(cur == null) break;
                ListNode next = cur.next;
                cur.next = front.next;
                front.next = cur;
                cur = next;
                if(back == front) {
                    back = front.next;
                }
            }
        }
        return dummy.next;
    }
}
