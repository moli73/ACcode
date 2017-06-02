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
    public int findTilt(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int tilt = Math.abs(right - left);
        res += tilt;
        return left + right + root.val;
    }
}
