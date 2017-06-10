/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // version 1: O(n^2)
public class Solution {
    private int res;
    public int largestBSTSubtree(TreeNode root) {
        int res = helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        if(res != -1) return res;
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    public int helper(TreeNode root, long low, long high){
        if(root == null) return 0;
        int left = helper(root.left, low, root.val);
        int right = helper(root.right, root.val, high);
        if(root.val >= high || root.val <= low) return -1;
        if(left == -1 || right == -1) return -1;
        res = Math.max(res, left + right + 1);
        return left + right + 1;
    }
}

//version 2: O(n)
public class Solution {
    class Result{
        int count, low, high;
        public Result(int count, int low, int high){
            this.count = count; this.low = low; this.high = high;
        }
    }
    private int res;
    public int largestBSTSubtree(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public Result helper(TreeNode root){
        if(root == null){ return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);}
        Result left = helper(root.left);
        Result right = helper(root.right);
        if(left.count == -1 || right.count == -1 || root.val <= left.high || root.val >= right.low){
            return new Result(-1, 0, 0);
        }
        res = Math.max(res, left.count + right.count + 1);
        return new Result(left.count + right.count + 1, Math.min(root.val, left.low), Math.max(root.val, right.high));
    }
}
