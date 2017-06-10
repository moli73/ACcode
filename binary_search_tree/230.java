/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //version 1:iteration of inorder traversal
 //time complexity is O(n)
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int count = 0;
        TreeNode cur = root;
        while(cur != null || !stack.empty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            count++;
            if(count == k) return cur.val;
            cur = cur.right;
        }
        return cur.val;
    }
}
//version 2:
// http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
// start:
// if K = root.leftElement + 1
//    root node is the K th node.
//    goto stop
// else if K > root.leftElements
//    K = K - (root.leftElements + 1)
//    root = root.right
//    goto start
// else
//    root = root.left
//    goto srart
// stop:
//time complexity O(h)
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = helper(root.left);
        if(count == k - 1) return root.val;
        else if(count > k - 1) return kthSmallest(root.left, k);
        else return kthSmallest(root.right, k - count - 1);
    }
    public int helper(TreeNode root){
        if(root == null) return 0;
        return 1 + helper(root.left) + helper(root.right);
    }
}
