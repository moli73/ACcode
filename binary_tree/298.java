//DFS
class Solution {
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return res;
    }

    private int res = 0;

    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int cur = 0;

        if(root.left == null || root.val + 1 != root.left.val) {//注意判空
            left = 0;
        }

        if(root.right == null || root.val + 1 != root.right.val) {
            right = 0;
        }

        cur = Math.max(left, right) + 1;

        res = Math.max(res, cur);

        return cur;
    }
}
//BFS
class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<Integer> qLen = new LinkedList<>();

        qNode.offer(root);
        qLen.offer(1);

        int res = 0;

        while(!qNode.isEmpty()) {

            TreeNode cur = qNode.poll();
            int len = qLen.poll();

            res = Math.max(len, res);

            if(cur.left != null) {
                qNode.offer(cur.left);
                if(cur.left.val == cur.val + 1) {
                    qLen.offer(len + 1);
                } else {
                    qLen.offer(1);
                }
            }

            if(cur.right != null) {
                qNode.offer(cur.right);
                if(cur.right.val == cur.val + 1) {
                    qLen.offer(len + 1);
                } else {
                    qLen.offer(1);
                }
            }
        }

        return res;
    }
}
