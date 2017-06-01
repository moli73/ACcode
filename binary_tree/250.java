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
    public int countUnivalSubtrees(TreeNode root) {
        int[] res = helper(root);
        return res[0];
    }
    public int[] helper(TreeNode root){
        int[] res = new int[4];
        if(root == null){
            res[0] = 0;
            res[1] = 1;
            res[2] = 1;
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(left[1] == 0 || right[1] == 0){
            res[0] = left[0] + right[0];
            res[1] = 0;
            res[2] = 0;
        }
        else{
            if((left[2] == 1 || left[3] == root.val) && (right[2] == 1 || right[3] == root.val)){
                res[0] = left[0] + right[0] + 1;
                res[1] = 1;
                res[2] = 0;
                res[3] = root.val;
            }
            else{
                res[0] = left[0] + right[0];
                res[1] = 0;
                res[2] = 0;
            }
        }
        return res;
    }
}

//better solution
public class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }

    public boolean helper(TreeNode root, int[] count){
        if(root == null) return true;

        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);

        if((left && right) && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)){
            count[0]++;
            return true;
        }
        else return false;
    }
}
