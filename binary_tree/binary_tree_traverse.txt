DFS:三种preorder，inorder，postorder遍历，recursion遍历，分治遍历，iteration遍历，morris迭代遍历四种方法
preorder：
//version 1: recursion traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preOrderTra(res, root);
        return res;
    }
    public void preOrderTra(List<Integer> res, TreeNode root){
        if(root == null) return;

        res.add(root.val);
        preOrderTra(res, root.left);
        preOrderTra(res, root.right);
    }
}

//version 2: divide and conquer
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;

        List<Integer> left = preorderTraversal(root.left);
        List<Integer> right = preorderTraversal(root.right);

        res.add(root.val);
        res.addAll(left);
        res.addAll(right);

        return res;
    }
}

//version 3: iteration traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            res.add(cur.val);
            if(cur.right != null) stack.push(cur.right);//先右孩子入堆栈
            if(cur.left != null) stack.push(cur.left);
        }
        return res;
    }
}

//version 4: morris iteration traversal
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode pre = cur.left;
                while(pre.right != null && pre.right != cur) pre = pre.right;
                if(pre.right == null){
                    pre.right = cur;
                    res.add(cur.val);//the difference from the inorder morris traversal
                    cur = cur.left;
                }
                else if(pre.right == cur){
                    pre.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}

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

postorder:
//version 1: recursion
public class Solution {
   public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       helper(res, root);
       return res;
   }

   public void helper(List<Integer> res, TreeNode root){
       if(root == null) return;
       helper(res, root.left);
       helper(res, root.right);
       res.add(root.val);
   }
}

//version 2: divide and conquer
public class Solution {
   public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       if(root == null) return res;

       List<Integer> left = postorderTraversal(root.left);
       List<Integer> right = postorderTraversal(root.right);

       res.addAll(left);
       res.addAll(right);
       res.add(root.val);

       return res;
   }
}

//version 3: iteration
public class Solution {
   public List<Integer> postorderTraversal(TreeNode root) {
       List<Integer> res = new ArrayList<Integer>();
       if(root == null) return res;
       Stack<TreeNode> stack = new Stack<TreeNode>();
       TreeNode pre = null, cur = root;
       stack.push(root);

       while(!stack.empty()){
           cur = stack.peek();
           if(pre == null || pre.left == cur || pre.right == cur){//此条件说明，1.起始状态pre为null，2.表示遍历方向是向下向左（左子树）3.表示遍历方向是向下向右
               if(cur.left != null) stack.push(cur.left);//后根遍历，先入栈左孩子
               else if(cur.right != null) stack.push(cur.right);//左子树空，则入栈右孩子
           }
           else if(cur.left == pre){//此条件说明，遍历方向是处在从左向上回溯
               if(cur.right != null) stack.push(cur.right);//若存在有孩子，则入栈
           }
           else{//剩余条件说明，遍历方向处在从右向上回溯。此时，可以退栈，输出结果
               res.add(cur.val);
               stack.pop();
           }
           pre = cur;//每次更新pre
       }

       return res;
   }
}
