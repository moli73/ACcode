/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //version 1: iteration traversal
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return;
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
            if(!stack.empty()) cur.right = stack.peek();
            cur.left = null;
        }
    }
}

//version 2: morris algorithm
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null) cur = cur.right;
            else{
                TreeNode pre = cur.left;
                while(pre.right != null) pre = pre.right;
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }
        }
    }
}
