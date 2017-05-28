/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //version 1: recursion
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(res, root);
        return res;
    }

    public void helper(List<Integer> res, TreeNode root){
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }
}

//version 2: divide and conquer
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);

        res.addAll(left);
        res.addAll(right);
        res.add(root.val);

        return res;
    }
}

//version 3: iteration
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null, cur = root;
        stack.push(root);

        while(!stack.empty()){
            cur = stack.peek();
            if(pre == null || pre.left == cur || pre.right == cur){
                if(cur.left != null) stack.push(cur.left);
                else if(cur.right != null) stack.push(cur.right);
            }
            else if(cur.left == pre){
                if(cur.right != null) stack.push(cur.right);
            }
            else{
                res.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }

        return res;
    }
}
