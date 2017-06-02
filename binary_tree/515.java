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
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.peek();
            int size = q.size(), temp = node.val;
            for(int i = 0; i < size; ++i){
                node = q.poll();
                temp = Math.max(temp, node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
