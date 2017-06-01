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
        TreeLinkNode head = root;
        TreeLinkNode head_next = null;
        while(head != null){
            TreeLinkNode cur = head, pre = null;
            while(cur != null){
                while(cur != null && cur.left == null && cur.right == null) cur = cur.next;
                if(cur == null) break;//it shows the last level
                if(head_next == null) head_next = (cur.left != null ? cur.left : cur.right);//find next level head
                if(cur.left != null && cur.right != null){//has two children
                    cur.left.next = cur.right;
                    if(pre != null) pre.next = cur.left;
                    pre = cur.right;
                }
                else{//has one children
                    if(cur.left != null){
                        if(pre != null) pre.next = cur.left;
                        pre = cur.left;
                    }
                    else{
                        if(pre != null) pre.next = cur.right;
                        pre = cur.right;
                    }
                }
                cur = cur.next;//move to right in current level
            }
            head = head_next;//move to next level
            head_next = null;
        }
    }
}

//better solution
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root, temp = new TreeLinkNode(0);
        while(cur != null){
            TreeLinkNode curChild = temp;
            while(cur != null){
                if(cur.left != null){curChild.next = cur.left; curChild = cur.left;}
                if(cur.right != null){curChild.next = cur.right; curChild = cur.right;}
                cur = cur.next;
            }
            cur = temp.next;
            temp.next = null;
        }
    }
}
