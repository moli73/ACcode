/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);
        int cur = 0;
        if(root.left != null && root.left.left == null && root.left.right == null) cur = root.left.val;
        return cur + left + right;
    }
}
