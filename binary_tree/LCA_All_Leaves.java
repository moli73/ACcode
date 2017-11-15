public TreeNode LCA(TreeNode root) {
    if(root == null) {
        return null;
    }

    叶子返回自己当LCA
    if(root.left == null && root.right == null) {
        return root;
    }

    TreeNode left = LCA(root.left);
    TreeNode right = LCA(root.right);

    左右子树都有leaves
    if(left != null && right != null) {
        return root;
    }

    if(left != null) {
        return left;
    }

    if(right != null) {
        return right;
    }

    叶子的情况
    return root;
}
