/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    private Random random;
    private ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.random = new Random();
        this.head = head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int res = 0;
        int count = 0;
        while(node != null) {
            count++;
            if(count == 1) {
                res = node.val;
            } else {
                int index = random.nextInt(count);
                if(index == 0) {
                    res = node.val;
                }
            }
            node = node.next;
        }

        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
