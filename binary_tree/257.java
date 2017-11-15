DFS, traversal, backtracking
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();

        helper(res, new String(), root);

        return res;
    }

    private void helper(List<String> res, String path, TreeNode root) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            res.add(path + String.valueOf(root.val));
            return;
        }

        if(root.left != null) {
            helper(res, path + String.valueOf(root.val) + "->", root.left);
        }

        if(root.right != null) {
            helper(res, path + String.valueOf(root.val) + "->", root.right);
        }
    }
}

BFS
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) {
            return res;
        }

        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<StringBuilder> qPath = new LinkedList<>();
        StringBuilder sb = new StringBuilder(String.valueOf(root.val));
        qNode.offer(root);
        qPath.offer(sb);

        while(!qNode.isEmpty()) {
            TreeNode cur = qNode.poll();
            StringBuilder path = qPath.poll();

            if(cur.left == null && cur.right == null) {
                res.add(path.toString());
            } else {
                if(cur.left != null) {
                    qNode.offer(cur.left);

                    StringBuilder leftPath = new StringBuilder(path);
                    leftPath.append("->" + String.valueOf(cur.left.val));
                    qPath.offer(leftPath);
                }
                if(cur.right != null) {
                    qNode.offer(cur.right);

                    StringBuilder rightPath = new StringBuilder(path);
                    rightPath.append("->" + String.valueOf(cur.right.val));
                    qPath.offer(rightPath);
                }
            }
        }
        return res;
    }
}
