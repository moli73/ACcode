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
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        int res = root.val;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(Math.abs(cur.val - target) < Math.abs(res - target)) res = cur.val;
            cur = cur.right;
        }
        return res;
    }
}

//better solution
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        TreeNode node = root;
        while(node != null){
            if(Math.abs(node.val - target) < Math.abs(res - target)) res = node.val;
            node = node.val < target ? node.right : node.left;
        }
        return res;
    }
}
