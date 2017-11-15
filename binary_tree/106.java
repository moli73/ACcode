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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }
    public TreeNode helper(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder){
        if(postEnd < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = inStart;
        for(int i = inStart; i <= inEnd; ++i){
            if(root.val == inorder[i])
                inIndex = i;
        }
        root.right = helper(postEnd - 1, inIndex + 1, inEnd, postorder, inorder);
        root.left = helper(postEnd - (inEnd - inIndex) - 1, inStart,inIndex - 1, postorder, inorder);
        return root;
    }
}

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int s1 = 0;
        int s2 = 0;
        int e1 = inorder.length - 1;
        int e2 = postorder.length - 1;
        return helper(postorder, inorder, s1, e1, s2, e2);
    }

    public TreeNode helper(int[] postorder, int[] inorder, int s1, int e1, int s2, int e2) {
        if(s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[e1]);

        int i = s2;
        while(inorder[i] != root.val) {
            i++;
        }

        root.left = helper(postorder, inorder, s1, s1 + i - s2 - 1, s2, i - 1);
        root.right = helper(postorder, inorder, s1 + i - s2, e1 - 1, i + 1, e2);
        return root;
    }
}
