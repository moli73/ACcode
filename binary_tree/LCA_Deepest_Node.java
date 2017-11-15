class Result {
        int depth;
        TreeNode node;
}


public Result deepestRoot(TreeNode root) {
        if (root == null) {
                return new Result(0, null);
        }

        Result left = deepestRoot(root.left);
        Result right = deepestRoot(root.right);

        Result ret = new Result();
        if (left.depth == right.depth) {
                //两边一样深,root 是公共
                ret.node = root;
                ret.depth = left.depth + 1;
        } else if (left.depth > right.depth) {
                //左边深,
                ret.node = left.node;
                ret.depth = left.depth + 1;
        } else {
                ret.node = right.node;
                ret.depth = right.depth + 1;
        }
        return ret;
}
