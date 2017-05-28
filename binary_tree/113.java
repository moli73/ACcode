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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, root, sum, comb);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int sum, List<Integer> comb){
        if(root == null) return;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                comb.add(root.val);
                res.add(new ArrayList(comb));
                comb.remove(comb.size() - 1);
            }
            return;
        }
        comb.add(root.val);
        helper(res, root.left, sum - root.val, comb);
        helper(res, root.right, sum - root.val, comb);
        comb.remove(comb.size() - 1);
    }
}

//to be succinct
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        helper(res, root, sum, comb);
        return res;
    }

    public void helper(List<List<Integer>> res, TreeNode root, int sum, List<Integer> comb){
        if(root == null) return;
        comb.add(root.val);
        if(root.left == null && root.right == null && root.val == sum){
            res.add(new ArrayList(comb));
        } else{
            helper(res, root.left, sum - root.val, comb);
            helper(res, root.right, sum - root.val, comb);
        }
        comb.remove(comb.size() - 1);
    }
}
