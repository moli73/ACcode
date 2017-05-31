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
    private class resultType{
        int rob;
        int not;
        resultType(int rob, int not){
            this.rob = rob;
            this.not = not;
        }
    }
    public int rob(TreeNode root) {
        resultType res = helper(root);
        return Math.max(res.rob, res.not);
    }

    public resultType helper(TreeNode root){
        resultType res = new resultType(0, 0);
        if(root == null) return res;

        resultType left = helper(root.left);
        resultType right = helper(root.right);

        res.rob = left.not + right.not + root.val;
        res.not = Math.max(left.not, left.rob) + Math.max(right.not, right.rob);

        return res;
    }
}
