 //BFS
 class Solution {
     public int minDepth(TreeNode root) {
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

                 if(node.left == null && node.right == null) {
                     return level;
                 }

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
//DFS
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(left == 0 && right == 0) {//叶子节点
            return 1;
        }

        if(left == 0 || right == 0) {//只有一个subtree
            return Math.max(left, right) + 1;
        }

        return Math.min(left, right) + 1;//左右子树都存在
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }
}
