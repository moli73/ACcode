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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        int[] size = findSize(root);
        initialList(res, size);
        helper(res, root, 0, 0, size[1] - 1);
        return res;
    }
    public int[] findSize(TreeNode root) {
        int[] res = new int[2];
        if(root == null) {
            return res;
        }
        int[] left = findSize(root.left);
        int[] right = findSize(root.right);
        res[0] = Math.max(left[0], right[0]) + 1;
        res[1] = Math.max(left[1], right[1]) * 2 + 1;
        return res;
    }
    public void initialList(List<List<String>> res, int[] size) {
        int m = size[0], n = size[1];
        for(int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                row.add(new String());
            }
            res.add(new ArrayList<String>(row));
        }
    }
    public void helper(List<List<String>> res, TreeNode root, int row, int start, int end) {
        if(root == null || row == res.size() || start > end) {
            return;
        }
        int mid = start + (end - start + 1) / 2;
        res.get(row).set(mid, String.valueOf(root.val));
        helper(res, root.left, row + 1, start, mid - 1);
        helper(res, root.right, row + 1, mid + 1, end);
    }
}
