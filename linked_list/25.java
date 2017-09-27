/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode front = dummy;
        ListNode back = dummy;
        ListNode cur = head;
        while(cur != null) {
            ListNode move = cur;
            front = back;
            for(int i = 0; i < k; i++) {
                if(cur == null) {
                    front.next = move;
                    return dummy.next;//不够k个node，要把后面的剩下节点连起来
                }
                cur = cur.next;
            }
            for(int i = 0; i < k; i++) {
                ListNode next = move.next;
                move.next = front.next;
                front.next = move;
                move = next;
                if(front == back) {
                    back = front.next;
                }
            }
        }
        return dummy.next;
    }
}
