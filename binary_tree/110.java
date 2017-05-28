/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //use the level of each node as the return value
public class Solution {
    public boolean isBalanced(TreeNode root) {
        int res = helper(root, 0);
        return res != -1;
    }
    public int helper(TreeNode root, int level){
        if(root == null || level == -1) return level;

        int left = helper(root.left, level + 1);
        int right = helper(root.right, level + 1);

        if(Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right);
    }
}

//use the height of the subtree as the return value(better)
public class Solution{
    public boolean isBalanced(TreeNode root){
        return helper(root) != -1;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        if(Math.abs(right - left) > 1 || left == -1 || right == -1) return -1;
        else return Math.max(right, left) + 1;
    }
}
