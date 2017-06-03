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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        TreeNode leftNode = root, rightNode = root;
        int leftHeight = 0, rightHeight = 0;
        while(leftNode != null){leftHeight++; leftNode = leftNode.left;}
        while(rightNode != null){rightHeight++; rightNode = rightNode.right;}
        if(leftHeight == rightHeight) return (1 << rightHeight) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
