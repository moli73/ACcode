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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        TreeNode node = null;
        while(!q.isEmpty()){
            node = q.poll();
            if(node.right != null) q.offer(node.right);
            if(node.left != null) q.offer(node.left);
        }
        return node.val;
    }
}
