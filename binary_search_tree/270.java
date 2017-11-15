iteration:
class Solution {
    public int closestValue(TreeNode root, double target) {

        TreeNode cur = root;
        int res = root.val;

        while(cur != null) {
            if(cur.val == target) {
                return cur.val;
            }

            if(Math.abs(target - cur.val) < Math.abs(target - res)) {
                res = cur.val;
            }

            if(cur.val < target) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }
        return res;
    }
}

recursion: traverse solution
class Solution {
    private int res;

    public int closestValue(TreeNode root, double target) {
        res = root.val;
        helper(root, target);
        return res;
    }

    public void helper(TreeNode root, double target) {
        if(root == null) {
            return;
        }

        if(root.val == target) {
            res = root.val;
            return;
        }

        if(Math.abs(target - res) > Math.abs(target - root.val)) {
            res = root.val;
        }

        if(root.val > target) {
            helper(root.left, target);
        } else {
            helper(root.right, target);
        }
    }
}

recursion: divide and conquer + traverse
class Solution {
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }

    public int helper(TreeNode root, double target, int res) {
        if(root == null) {
            return res;
        }

        if(root.val == target) {
            return root.val;
        }

        if(Math.abs(root.val - target) < Math.abs(res - target)) {
            res = root.val;
        }

        if(root.val < target) {
            res = helper(root.right, target, res);
        } else {
            res = helper(root.left, target, res);
        }

        return res;
    }
}
