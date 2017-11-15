inorder：
//
public class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       help(res, root);
       return res;
   }

   public void help(List<Integer> res, TreeNode root){
       if(root == null) return;
       help(res, root.left);
       res.add(root.val);
       help(res, root.right);
   }
}
//
public class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       if(root == null) return res;

       List<Integer> left = inorderTraversal(root.left);
       List<Integer> right = inorderTraversal(root.right);

       res.addAll(left);
       res.add(root.val);
       res.addAll(right);

       return res;
   }
}
//important, iteration traversal
public class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       Stack<TreeNode> stack = new Stack<TreeNode>();
       TreeNode node = root;
       while(node != null || !stack.empty()){当前node为null且堆栈空时退出
           while(node != null){//遍历左子树，到最最左
               stack.push(node);
               node = node.left;
           }
           node = stack.pop();//遍历根，输出
           res.add(node.val);
           node = node.right;//遍历右子树
       }
       return res;
   }
}
//morris traversal
public class Solution {
   public List<Integer> inorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       TreeNode cur = root;
       while(cur != null){
           if(cur.left == null){//1.current node doesn't have left child, so it is time to output it
               res.add(cur.val);
               cur = cur.right;
           }
           else{
               TreeNode pre = cur.left;
               while(pre.right != null && pre.right != cur) pre = pre.right;
               if(pre.right == null){//2.1 find the rightmost node of the left sub tree of the current node, left the current node be its right child
                   pre.right = cur;
                   cur = cur.left;
               }
               else if(pre.right == cur){//2.2 it is time to ouput the current node (which has left child), and we need to restore the origin tree structure
                   pre.right = null;
                   res.add(cur.val);
                   cur = cur.right;
               }
           }
       }
       return res;
   }
}
