solution2: recursion（不改变结构）
注意有个global cur node
time: O(n)
space: O(1)   stack space O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        cur = head;
        return helper(head);
    }

    private ListNode cur;

    public boolean helper(ListNode head) {
        if(head == null) return true;    如果head == null不算palindrome要在母函数里面单独排除

        if(!helper(head.next)) return false; 子问题是否palindrome

        if(cur.val != head.val) {    当前是否palindrome
            return false;
        }

        cur = cur.next;    移动current指针
        return true;
    }
}

讨论，空链表是否palindrome
solution1: (改变了结构)
快慢指针找中点，然后reverse后一部分，比较是否相同
time:
T(n) = O(n) + O(n / 2) + O(n) = O(n)
space: O(1)
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse second half
        ListNode dummy = new ListNode(0);
        while(slow != null) {
            ListNode next = slow.next;

            slow.next = dummy.next;
            dummy.next = slow;

            slow = next;
        }

        ListNode p1 = dummy.next;
        ListNode p2 = head;
        while(p1 != null) {
            if(p1.val != p2.val) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return true;
    }
}

solution3: stack
time: O(n)
space: O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        cur = head;
        while(cur != null) {
            if(cur.val != stack.pop().val) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}

List<ListNode> list = new ArrayList<>();
list.add(cur);
cur = cur.next;
