/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        Stack<TreeNode> s = new Stack<>();
        for (int num : A) {
            TreeNode node = new TreeNode(num);
            while (!s.empty() && num > s.peek().val) {
                TreeNode cur = s.pop();
                if (!s.empty() && num > s.peek().val) {
                    s.peek().right = cur;
                } else {
                    node.left = cur;
                }
            }
            s.push(node);
        }

        TreeNode root = s.pop();
        while(!s.empty()) {
            s.peek().right = root;
            root = s.pop();
        }

        return root;
    }
}
