/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) return head;
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode temp = head;
        ListNode pre = dump;
        while(temp != null){
            ListNode move = dump.next;
            ListNode pre_move = dump;
            while(move != temp && move.val < temp.val){
                pre_move = move;
                move = move.next;
            }
            if(move == temp){
                pre = temp;
                temp = temp.next;
                continue;
            }
            pre.next = temp.next;
            temp.next = pre_move.next;
            pre_move.next = temp;
            temp = pre.next;
        }
        return dump.next;
    }
}
