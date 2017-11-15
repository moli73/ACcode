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
https://discuss.leetcode.com/topic/32792/java-divide-and-conquer-solution-considering-augmenting-tree-structure-for-the-follow-up
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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int left = count(root.left);
        if(left == k - 1) {
            return root.val;
        } else if(left > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - left - 1);
        }
    }

    public int count(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = count(root.left);
        int right = count(root.right);

        return left + right + 1;
    }
}
