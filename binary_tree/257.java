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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        // String path = new String();
        // helper(root, res, path);
        helper(root, res, "");
        return res;
    }

    public void helper(TreeNode root, List<String> res, String path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            // path += root.val;
            // res.add(path);
            res.add(path + root.val);
        }
        else{
            helper(root.left, res, path + root.val + "->");
            helper(root.right, res, path + root.val + "->");
        }
    }
}
