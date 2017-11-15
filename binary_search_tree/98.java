//最佳recursion解法
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.val <= min.val) return false;
        if(max != null && root.val >= max.val) return false;
        boolean left = helper(root.left, min, root);
        boolean right = helper(root.right, root, max);
        return left && right;
    }
}


public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long low, long high){
        if(root == null) return true;
        boolean left = helper(root.left, low, root.val);
        boolean right = helper(root.right, root.val, high);
        return left && right && (root.val > low) && (root.val < high);
    }
}

//iteration solution
time: O(n) n是节点的个数
space: O(h) h是树的高度（表示递归深度），worst case是n，一条线的时候
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null || !stack.empty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//out put node

            if(pre != null && pre.val >= cur.val) {//check valid, special for the first node
                return false;
            }

            pre = cur;
            cur = cur.right;
        }
        return true;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Result {
        boolean isValid;
        long min;
        long max;
        public Result(long min, long max, boolean isValid) {
            this.min = min;
            this.max = max;
            this.isValid = isValid;
        }
    }

    public boolean isValidBST(TreeNode root) {
        Result res = helper(root);

        return res.isValid;
    }

    public Result helper(TreeNode root) {

        if(root == null) {

            return new Result(Long.MAX_VALUE, Long.MIN_VALUE, true);

        }

        Result left = helper(root.left);
        Result right = helper(root.right);

        if(!left.isValid || !right.isValid || root.val <= left.max || root.val >= right.min) {

            return new Result(0, 0, false);

        }

        long min = Math.min(root.val, left.min);
        long max = Math.max(root.val, right.max);

        return new Result(min, max, true);

    }
}

/*
          1                1:(1, -inf)
         ／
         1             1:(1,1)   (inf, -inf)
                        (inf, -inf)
*/
