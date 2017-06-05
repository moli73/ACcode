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
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        String cur = new String();
        cur += t.val;
        if(left.length() == 0 && right.length() == 0) return cur;
        if(right.length() == 0) return cur + '(' + left + ')';
        return cur + '(' + left + ')' + '(' + right + ')';
    }
}
