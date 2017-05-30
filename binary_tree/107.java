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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> res = new LinkedList<List<Integer>>();//implement by LinkedList

        if(root != null) queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> comb = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; ++i){
                TreeNode cur = queue.poll();
                comb.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(0, new ArrayList<Integer>(comb));//
        }
        return res;
    }
}
