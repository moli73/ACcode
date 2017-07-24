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
    public void recoverTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        while(cur != null) {
            if(cur.left == null) {

                if(pre != null && pre.val > cur.val) {
                    if(first == null) {
                        first = pre;
                        second = cur;
                    } else {
                        second = cur;
                    }
                }

                pre = cur;
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }

                if(temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                } else if(temp.right == cur){
                    temp.right = null;

                    if(pre != null && pre.val > cur.val) {
                        if(first == null) {
                            first = pre;
                            second = cur;
                        } else {
                            second = cur;
                        }
                    }

                    pre = cur;
                    cur = cur.right;
                }
            }
        }

        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
}
