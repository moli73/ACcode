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
    public int maxPathSum(TreeNode root) {
        res = Integer.MIN_VALUE;
        helper(root);
        return res;
    }
    public int[] helper(TreeNode root){
        int[] sum = new int[2];
        if(root == null) return sum;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int leftMax = Math.max(left[0], left[1]), rightMax = Math.max(right[0], right[1]);
        sum[0] = leftMax > 0 ? leftMax + root.val : root.val;
        sum[1] = rightMax > 0 ? rightMax + root.val : root.val;
        res = Math.max(res, sum[0] + sum[1] - root.val);
        return sum;
    }
}

//more succint solution
public class Solution {
    int maxValue;

    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
