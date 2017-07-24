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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<TreeNode> cand = new ArrayList<TreeNode>();
        stack.push(s);;
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            if(cur.val == t.val) cand.add(cur);
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
        }
        for(int i = 0; i < cand.size(); ++i){
            if(helper(cand.get(i), t)) return true;
        }
        return false;
    }

    public boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        else if(s == null || t == null || s.val != t.val) return false;

        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}

//best solution, 分治套分治
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null) return true;//特殊case,如果s和t可以是empty tree
        if(s == null) return false;
        if(helper(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean helper(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        else if(s == null || t == null || s.val != t.val) return false;
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
