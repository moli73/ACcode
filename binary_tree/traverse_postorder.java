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

//version 3: iteration with stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;                 记录post order前一个node
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while(cur != null || !stack.empty()) {
            while(cur != null) {    不断往左子树遍历
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();      只取不pop
            if(cur.right == null || cur.right == pre) {   没有右子树，或者右子树已经被遍历过
                res.add(cur.val);
                stack.pop();          则当前root可以遍历了，同时pop出栈

                pre = cur;          更新pre
                cur = null;         tricky cur要变null
            } else {
                cur = cur.right;    遍历右子树
            }
        }

        return res;
    }
}
