public class Solution {
    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // Write your code here
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode pre = dummy;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();

        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            DoublyListNode node = new DoublyListNode(cur.val);
            pre.next = node;
            node.prev = pre;

            pre = pre.next;

            cur = cur.right;
        }
        return dummy.next;
    }
}
