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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode node = null;
            for(int i = 0; i < size; ++i) {
                node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(node.val);
        }
        return res;
    }
}
