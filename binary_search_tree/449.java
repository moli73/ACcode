/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String cur = new String();
        if(root == null) return cur;
        String left = serialize(root.left);
        String right = serialize(root.right);
        cur += root.val;
        StringBuilder sb = new StringBuilder(cur + ",");
        sb.append(left  + right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] nodes = data.split(",");
        int[] nums = new int[nodes.length];
        for(int i = 0; i < nodes.length; ++i) nums[i] = Integer.parseInt(nodes[i]);
        return deserialize(0, nums.length - 1, nums);
    }

    private TreeNode deserialize(int start, int end, int[] nums){
        if(start > end) return null;
        TreeNode root = new TreeNode(nums[start]);
        int leftEnd = start, rightStart = leftEnd + 1;
        for(int i = start + 1; i <= end; ++i){
            if(nums[start] < nums[i]) break;
            leftEnd = i;
            rightStart = leftEnd + 1;
        }
        root.left = deserialize(start + 1, leftEnd, nums);
        root.right = deserialize(rightStart, end, nums);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
