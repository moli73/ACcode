//iteration
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        TreeNode cur = root;
        while(cur != null) {
            if(p.val <= cur.val && cur.val <= q.val) {
                return cur;
            }//横跨两边

            if(cur.val < p.val) {
                cur = cur.right;
            } else if(cur.val > q.val) {
                cur = cur.left;
            }
        }
        return cur;
    }
}

//recurtion
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) {//p，q在root的左边
            return lowestCommonAncestor(root.right, p, q);
        } else if(root.val > p.val && root.val > q.val) {//p，q在root的右边
            return lowestCommonAncestor(root.left, p, q);
        } else {//横跨两边
            return root;
        }
    }
}
