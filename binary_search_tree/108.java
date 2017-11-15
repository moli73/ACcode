
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);

        return root;
    }
}

class Solution {
    class Node {
        TreeNode node;
        int left;
        int right;
        public Node(TreeNode node, int left, int right) {
            this.node = node;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(nums[(nums.length - 1) / 2]);
        Node node = new Node(root, 0, nums.length - 1);

        Queue<Node> q = new LinkedList<Node>();
        q.offer(node);

        while(!q.isEmpty()) {
            Node cur = q.poll();

            int left = cur.left;
            int right = cur.right;
            int mid = left + (right - left) / 2;

            if(mid - 1 >= left) {
                TreeNode leftNode = new TreeNode(nums[left + (mid - 1 - left) / 2]);
                cur.node.left = leftNode;
                q.offer(new Node(leftNode, left, mid - 1));
            }

            if(right >= mid + 1) {
                TreeNode rightNode = new TreeNode(nums[mid + 1 + (right - mid - 1) / 2]);
                cur.node.right = rightNode;
                q.offer(new Node(rightNode, mid + 1, right));
            }
        }

        return root;

    }
}
