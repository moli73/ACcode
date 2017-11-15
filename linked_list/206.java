class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;

            cur.next = dummy.next;
            dummy.next = cur;

            cur = next;
        }

        return dummy.next;
    }
}

//The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;//head是当前的tail
        return temp;
    }
}

//stack
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        stack.push(null);
        while(cur != null) {
            ListNode next = cur.next;

            cur.next = stack.pop();

            stack.push(cur);

            cur = next;
        }

        return stack.pop();
    }
}
