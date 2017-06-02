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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        q.offer(root);
        while(!q.isEmpty()){
            if(!q.isEmpty()){
                int size = q.size();
                List<Integer> list = new ArrayList<Integer>();
                for(int i = 0; i < size; ++i){
                    TreeNode node = q.poll();
                    list.add(node.val);
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
                res.add(list);
            }
            if(!q.isEmpty()){
                int size = q.size();
                List<Integer> list = new ArrayList<Integer>();
                for(int i = 0; i < size; ++i){
                    TreeNode node = q.poll();
                    list.add(0, node.val);
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
                res.add(list);
            }
        }
        return res;
    }
}
