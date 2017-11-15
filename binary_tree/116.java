BFS:
time: O(n)
space: O(n)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode pre = null;

            for(int k = 0; k < size; k++) {

                TreeLinkNode cur = q.poll();

                if(pre != null) {

                    pre.next = cur;

                }
                pre = cur;

                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
    }
}

//constant space complexity
public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode cur = root;

        while(cur != null) {
            TreeLinkNode next = cur.left;//下一层起点

            while(next != null && cur != null) {//是否有下一层

                cur.left.next = cur.right;

                if(cur.next != null) {//本层是否到最后了。

                    cur.right.next = cur.next.left;

                }

                cur = cur.next;
            }

            cur = next;
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        if(root.left != null) {
            root.left.next = root.right;

            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }
}
