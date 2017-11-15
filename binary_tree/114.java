Stack preorder pre node Solution:
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        stack.push(root);

        while(!stack.empty()) {
            TreeNode cur = stack.pop();
            if(cur.right != null) {
                stack.push(cur.right);
            }
            if(cur.left != null) {
                stack.push(cur.left);
            }
            if(pre != null) {
                pre.left = null;  注意将pre node的left变成null
                pre.right = cur;
            }
            pre = cur;
        }

    }
}

recursion 利用last node 和right node
class Solution {
    private TreeNode last = null;
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        if(last != null) {
            last.left = null;  注意将pre node的left变成null
            last.right = root;
        }
        last = root;

        TreeNode right = root.right; 提前记录right，进行递归调用。

        flatten(root.left);
        flatten(right); 提前记录right，进行递归调用。

    }
}

space: O(1)
time: O(n)
//version 2: morris algorithm
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while(pre.right != null) pre = pre.right;

                pre.right = cur.right;

                cur.right = cur.left;

                cur.left = null;

                cur = cur.right;
            }
        }
    }
}


============================================
public class Solution {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return;
        stack.push(root);
        while(!stack.empty()){
            TreeNode cur = stack.pop();
            if(cur.right != null) stack.push(cur.right);
            if(cur.left != null) stack.push(cur.left);
            if(!stack.empty()) cur.right = stack.peek();
            cur.left = null;  注意将pre node的left变成null
        }
    }
}

//version 2: morris algorithm
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null) cur = cur.right;
            else{
                TreeNode pre = cur.left;
                while(pre.right != null) pre = pre.right;
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
                cur = cur.right;
            }
        }
    }
}
