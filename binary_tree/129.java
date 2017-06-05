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
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode root, int sum){
        if(root == null) return;
        if(root.left == null && root.right == null) res += root.val + 10 * sum;
        helper(root.left, 10 * sum + root.val);
        helper(root.right, 10 * sum + root.val);
    }
}
