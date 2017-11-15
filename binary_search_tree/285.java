//version 1: without stack
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null) {

            if(cur.val <= p.val) {
                cur = cur.right;
            } else {
                pre = cur;
                cur = cur.left;
            }
        }
        return pre;
    }
}

/*
        4   <---
       / \
      2   5
     / \
    1   3 <--

    successor > p.val
    find larger than p, nut smallest
    cur > p.val   pre = cur; cur = cur.left
    cur == p.val  cur = cur.right
    cur < p.val  cur = cur.right
*/

// version 2: with stack
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

//recursion solution:
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

let's take the successor for example, basically we always want to find p's closest node (in inorder traversal) and the node's value is larger than p's value, right? That node can either be p's parent or the smallest node in p' right branch.

When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.

If it's p's parent node, there are two scenarios: 1. p doesn't have right child, in this case, the recursion will eventually return null, so p's parent is the successor; 2. p has right child, then the recursion will return the smallest node in the right sub tree, and that will be the answer.

If it's p's right child, there are two scenarios: 1. the right child has left sub tree, eventually the smallest node from the left sub tree will be the answer; 2. the right child has no left sub tree, the recursion will return null, then the right child (root) is our answer.

I guess it's hard to understand unless you draw different scenarios out. :)
