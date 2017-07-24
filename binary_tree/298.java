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
    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        int cur = 0;
        if(root == null) return cur;
        int left = helper(root.left);
        int right = helper(root.right);
        if(root.left != null && root.left.val != root.val + 1) left = 0;
        if(root.right != null && root.right.val != root.val + 1) right = 0;
        cur = Math.max(left, right) + 1;
        res = Math.max(cur, res);
        return cur;
    }
}





/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
最佳答案：
public class Solution {
    private int res;
    public int longestConsecutive(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }
    public int helper(TreeNode root){
        int cur = 0;
        if(root == null) return cur;
        int left = helper(root.left);
        int right = helper(root.right);
        int leftres = 0, rightres = 0;
        if(left == 0 || root.val + 1 == root.left.val) leftres = left;
        if(right == 0 || root.val + 1 == root.right.val) rightres = right;
        cur = Math.max(leftres, rightres) + 1;
        res = Math.max(cur, res);
        return cur;
    }
}


   private int anw = 0;
   public int longestConsecutive(TreeNode root) {
       anw = 0;
       helper(root);
       return anw;
   }

   public int[] helper(TreeNode root){
       int[] res = new int[2];//res[0] is number, res[1] is the number of nodes
       if(root == null) return res;
       int[] left = helper(root.left);
       int[] right = helper(root.right);
       int leftres = 0, rightres = 0;
       if(left[1] == 0 || root.val + 1 == left[0]) leftres = left[1]; （多余了，因为左孩子和右孩子的值在当前层是可以检查的。）
       if(right[1] == 0 || root.val + 1 == right[0]) rightres = right[1];
       res[0] = root.val;
       res[1] = Math.max(leftres, rightres) + 1;
       anw = Math.max(anw, res[1]);
       return res;
   }
