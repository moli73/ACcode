/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        if(root == null) return;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeLinkNode node = null;
            for(int i = 0; i < size; ++i){
                node = q.poll();
                if(i != size - 1) node.next = q.peek();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
    }
}

//constant space complexity
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_head = root;
        while(level_head != null){
            TreeLinkNode cur = level_head;
            while(cur != null){
                if(cur.left != null){
                    cur.left.next = cur.right;
                    if(cur.next != null) cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            level_head = level_head.left;
        }
    }
}
