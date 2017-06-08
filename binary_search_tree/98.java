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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long low, long high){
        if(root == null) return true;
        boolean left = helper(root.left, low, root.val);
        boolean right = helper(root.right, root.val, high);
        return left && right && (root.val > low) && (root.val < high);
    }
}

//iteration solution
public class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(pre != null && cur.val <= pre.val) return false;
            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}
