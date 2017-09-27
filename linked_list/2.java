/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int c = 0;
        while(c != 0 || l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            if(l1 != null) {
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                num2 = l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode((num1 + num2 + c) % 10);
            c = (num1 + num2 + c) / 10;
            temp.next = tail.next;
            tail.next = temp;
            tail = tail.next;
        }
        return dummy.next;
    }
}
