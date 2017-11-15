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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        helper(root, res);
        return res[0];
    }
    public int helper(TreeNode root, int[] res){
        if(root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        res[0] = Math.max(right + left, res[0]);
        return Math.max(right, left) + 1;
    }
}

class Solution {
    private int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int cur = Math.max(left, right) + 1;
        res = Math.max(res, left + right + 1 - 1);
        return cur;
    }
}

/*
               1
              /  \
             2    3
            / \
            4  1

*/
