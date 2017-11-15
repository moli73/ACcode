但是利用BST的有序性，left subtree < root < right subtree,方法有改进。
(注意null，val越界的情况。)
solution3:  利用recursion的性质,就不需要加"#"来表示空节点
encode: BST preorder encode,
time: O(n)
space: approximately O(n)

decode: 借助 recursion的性质 类比109. Convert Sorted List to Binary Search Tree
time: O(n)
spacce: O(n)
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        helper(root);
        return sb.toString();
    }

    private StringBuilder sb = new StringBuilder();

    public void helper(TreeNode root) {
        if(root == null) return;
        sb.append(String.valueOf(root.val) + ",");
        helper(root.left);
        helper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        String[] arr = data.split(",");

        return helper(arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private int index = 0;

    public TreeNode helper(String[] arr, int left, int right) {
        if(index >= arr.length) {
            return null;
        }

        int num = Integer.parseInt(arr[index]);
        if(num < left || num > right) {    超出范围，则是null node
            return null;
        } else {                    满足范围，则创建root，移动index
            index++;
        }

        TreeNode root = new TreeNode(num);
        root.left = helper(arr, left, root.val);
        root.right = helper(arr, root.val, right);

        return root;
    }
}


solution2: 用BST preorder encode, 做partition decode
decode:
time: O(nlogn)  since T(n) = 2T(n/2) + O(n)  = O(nlogn)
（或者每次二分T(n) = 2T(n/2) + O(logn) = O(n)类似越heapy)
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
