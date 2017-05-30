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
    public int pathSum(TreeNode root, int sum) {//preorder traversal, divide and conquer version
        if(root == null) return 0;
        return  helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int helper(TreeNode root, int sum){//divide and conquer version to find the path
        int res = 0;
        if(root == null) return res;
        if(root.val == sum) res++;
        return res + helper(root.left, sum - root.val) + helper(root.right, sum - root.val);
    }
}
// Each time find all the path start from current node
// Then move start node to the child and repeat.
// Time Complexity should be O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
//template version
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;

        int left = pathSum(root.left, sum);
        int right = pathSum(root.right, sum)

        return  helper(root, sum) + left + right;
    }

    public int helper(TreeNode root, int sum){
        if(root == null) return 0;

        int left = helper(root.left, sum - root.val);
        int right = helper(root.right, sum - root.val);

        if(root.val == sum) return left + right + 1;
        else return left + right;
    }
}
