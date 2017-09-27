/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode temp;
    public boolean isPalindrome(ListNode head) {
        if(head == null) {
            return true;
        }
        if(temp == null ) temp = head;
        if(isPalindrome(head.next) && temp.val == head.val) {
            temp = temp.next;
            return true;
        }
        return false;
    }
}
