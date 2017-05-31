/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //version 1: recursion
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        else if(l == null || r == null || l.val != r.val) return false;

        boolean left = helper(l.left, r.right);
        boolean right = helper(l.right, r.left);

        return left && right;
    }
}

//version 2; iteration from DFS
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        if(root == null) return true;
        s1.push(root);
        s2.push(root);
        while(!s1.empty() || !s2.empty()){
            if(s1.empty() || s2.empty()) return false;
            TreeNode cur1 = s1.pop();
            TreeNode cur2 = s2.pop();
            if(cur1 == null && cur2 == null) continue;
            else if(cur1 == null || cur2 == null || cur1.val != cur2.val) return false;
            s1.push(cur1.left);
            s1.push(cur1.right);
            s2.push(cur2.right);
            s2.push(cur2.left);
        }
        return true;
    }
}

//version 3: iteration from BFS
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null || t1.val != t2.val) return false;
            q.offer(t1.left);
            q.offer(t2.right);
            q.offer(t1.right);
            q.offer(t2.left);
        }
        return true;
    }
}
