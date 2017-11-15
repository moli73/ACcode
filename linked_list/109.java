class Solution {

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }

        node = head;
        return helper(1, size);
    }

    private TreeNode helper(int start, int end) {

        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode left = helper(start, mid - 1);

        TreeNode root = new TreeNode(node.val);
        node = node.next;//全局变量，十分trikcy

        TreeNode right = helper(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}
