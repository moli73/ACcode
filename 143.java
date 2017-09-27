/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode slow = dump;
        ListNode fast = dump;
        //step1: find the middle of the list
        while(fast != null && fast.next != null){//tricky: check the fast null first then check the fast.next null
            slow = slow.next;
            fast = fast.next.next;
        }
        //now the slow is the pre node of the start of the second half
        ListNode temp = slow.next;
        slow.next = null;//separate the list
        //step2: reverse the second half list node
        while(temp != null){
            ListNode buff = temp.next;
            temp.next = slow.next;
            slow.next = temp;
            temp = buff;
        }
        //step3: merge the two list
        ListNode h1 = head;
        ListNode h2 = slow.next;
        slow.next = null;//separate the list
        while(h2 != null){
            ListNode buff = h2.next;
            h2.next = h1.next;
            h1.next = h2;

            h1 = h2.next;
            h2 = buff;
        }
    }
}
