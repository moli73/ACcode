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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);
            while(!stack.empty() && stack.peek().val < nums[i]) {
                TreeNode temp = stack.pop();
                if(stack.empty() || stack.peek().val > nums[i]) {
                    cur.left = temp;
                    break;
                } else {
                    stack.peek().right = temp;
                }
            }
            stack.push(cur);
        }
        while(!stack.empty()) {
            TreeNode temp = stack.pop();
            if(!stack.empty()) {
                stack.peek().right = temp;
            } else {
                return temp;
            }
        }
        return null;
    }
}
