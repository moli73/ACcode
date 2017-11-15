每次计算出preorder中左子树，右子树的起点。
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart >= preorder.length || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        for(int i = inStart; i <= inEnd; ++i){
            if(inorder[i] == root.val)
                inIndex = i;
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}

全局变量家记录preorder的扫描结果。
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n1 = preorder.length;
        int n2 = inorder.length;
        s1 = 0;
        e1 = n1 - 1;
        return helper(preorder, inorder, 0, n2 - 1);
    }
    private int s1;
    private int e1;
    public TreeNode helper(int[] preorder, int[] inorder, int s2, int e2) {
        if(s2 > e2) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[s1++]);

        int i = s2;
        while(inorder[i] != root.val) {
            i++;
        }
        root.left = helper(preorder, inorder, s2, i - 1);
        root.right = helper(preorder, inorder, i + 1, e2);

        return root;
    }
}
