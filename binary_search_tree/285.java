/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // version 1: with stack
public class Solution {//modification of inorder traversal iteration
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(cur == p){
                cur = cur.right;
                if(cur == null){
                    if(stack.empty()) return null;//for case: [0]
                    cur = stack.pop();
                    return cur;
                }
                while(cur.left != null){
                    cur = cur.left;
                }
                return cur;
            }
            cur = cur.right;
        }
        return cur;
    }
}
//version 2: without stack
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root, pre = null;
        while(cur != null){
            if(p.val < cur.val){
                pre = cur;
                cur = cur.left;
            } else{
                cur = cur.right;
            }
        }
        return pre;
    }
}


//other solutios and extension
Successor

public TreeNode successor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val <= p.val) {
    return successor(root.right, p);
  } else {
    TreeNode left = successor(root.left, p);
    return (left != null) ? left : root;
  }
}
Predecessor

public TreeNode predecessor(TreeNode root, TreeNode p) {
  if (root == null)
    return null;

  if (root.val >= p.val) {
    return predecessor(root.left, p);
  } else {
    TreeNode right = predecessor(root.right, p);
    return (right != null) ? right : root;
  }
}
