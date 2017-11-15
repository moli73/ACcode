public class Solution {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    public int helper(TreeNode root){
        if(root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        return Math.max(left, right) + 1;
    }
}
//BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int level = 0;

        while(!q.isEmpty()) {
            level++;
            int size = q.size();

            for(int k = 0; k < size; k++) {
                TreeNode node = q.poll();

                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return level;
    }
}
