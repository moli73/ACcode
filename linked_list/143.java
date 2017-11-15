/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {   找中点模版
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode dummy = new ListNode(0);
        while(slow != null) {                       1->2->3<-4<-5    1->2->3<-4
            ListNode next = slow.next;

            slow.next = dummy.next;
            dummy.next = slow;

            slow = next;
        }


        ListNode p1 = head;                insert后一半到前一半
        ListNode p2 = dummy.next;           奇数个，相等退出。偶数个，next相等退出。

        while(p1 != p2 && p1.next != p2) {   终止条件tricky需要举例子思考
            ListNode next = p2.next;
            p2.next = p1.next;
            p1.next = p2;

            p1 = p1.next.next;
            p2 = next;
        }
    }
}
