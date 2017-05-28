/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//version 1: recursion traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preOrderTra(res, root);
        return res;
    }
    public void preOrderTra(List<Integer> res, TreeNode root){
        if(root == null) return;

        res.add(root.val);
        preOrderTra(res, root.left);
        preOrderTra(res, root.right);
    }
}

//version 2: divide and conquer
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        res.add(root.val);
        res.addAll(left);
        res.addAll(right);

        return res;
    }
}

//version 3: iteration traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
}

//version 4: morris iteration traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur) pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    res.add(cur.val);//the difference from the inorder morris traversal
                    cur = cur.left;
                }
                else if(pre.right == cur){
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
