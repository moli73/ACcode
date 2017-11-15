//put preprocess into hasNext()
//则在next()前，一定要先做hasNext();
//time O(n)
//space O(h)
public class BSTIterator {

    private Stack<TreeNode> stack;
    private TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        node = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(node == null && stack.empty()) {
            return false;
        }
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        int res = node.val;
        node = node.right;
        return res;
    }
}

//better solution
//因为不一定先做hasNext(), 再做next()
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
