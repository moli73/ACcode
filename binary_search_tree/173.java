/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private TreeNode node;
    private Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.node = root;
        this.stack = new Stack<TreeNode>();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.node != null || !this.stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        while(this.node != null){
            this.stack.push(this.node);
            this.node = this.node.left;
        }
        this.node = this.stack.pop();
        int res = this.node.val;
        this.node = this.node.right;
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
