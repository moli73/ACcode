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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(root, res);
        return res;
    }
    public int helper(TreeNode root, List<List<Integer>> res){
        if(root == null) return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int cur = Math.max(left, right) + 1;
        // if(cur > res.size()){
        //     ArrayList<Integer> list = new ArrayList<Integer>();
        //     list.add(root.val);
        //     res.add(list);
        // } else{
        //     res.get(cur - 1).add(root.val);
        // }
        if(cur > res.size()) res.add(new ArrayList<Integer>());
        res.get(cur - 1).add(root.val);
        return cur;
    }
}
