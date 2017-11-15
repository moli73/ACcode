class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) {
            return false;
        }
        BSTIterator left = new BSTIterator(root, true);
        BSTIterator right = new BSTIterator(root, false);

        int a = left.next();
        int b = right.next();
        while(a != b) {
            if(a + b == k) {
                return true;
            }
            if(a + b > k) {
                b = right.next();
            } else {
                a = left.next();
            }
        }
        return false;
    }
}

class BSTIterator {
    private boolean asc;
    private Stack<TreeNode> stack;
    private TreeNode node;

    public BSTIterator(TreeNode root, boolean asc) {
        this.asc = asc;
        stack = new Stack<TreeNode>();
        node = root;
    }

    public boolean hasNext() {
        if(stack.empty() && node == null) {
            return false;
        }
        return true;
    }

    public int next() {
        while(node != null) {
            stack.push(node);
            node = asc ? node.left : node.right;
        }
        node = stack.pop();
        int res = node.val;
        node = asc ? node.right : node.left;
        return res;
    }
}


//
//time O(n)
//space O(n)
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);
    }

    private boolean helper(TreeNode root, int k, Set<Integer> set) {
        if(root == null) {
            return false;
        }

        if(set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);

        return helper(root.left, k, set) || helper(root.right, k, set);
    }
}
