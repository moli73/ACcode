solution3:转换成sorted array
time: O(n)
space: O(n)
变成108


solution2: two pass
time: O(n)
space: O(1)
step1：统计list总长度。
step2：inorder traverse + 分治法，（从下到上）
start : mid-1   建立左子树
mid建立root节点
mid + 1: end   建立右子树

扫描list的指针必须要是全局变量

time: O(n)
sapce: O(1)
class Solution {

    private ListNode node;

    public TreeNode sortedListToBST(ListNode head) {
        int size = 0;
        ListNode cur = head;
        while(cur != null) {
            size++;
            cur = cur.next;
        }

        node = head;
        return helper(1, size);
    }

    private TreeNode helper(int start, int end) {

        if(start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        TreeNode left = helper(start, mid - 1);

        TreeNode root = new TreeNode(node.val);
        node = node.next;

        TreeNode right = helper(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
}

solution1: stack, fast and slow pointers
通过快慢指针找到middle，使其成为root，
然后递归
用前一半构建left sub tree
用后一半构建right sub tree
time: 因为是平衡二叉树，所以h = logn；
找middle time： O(n/2)
T(n) = 2T(n/2) + O(n/2) = 2(2T(n/4) + O(n/4)) + O(n/2)
\=4T(n/4) + O(n/2 + n/2) = 4(2T(n/8) + O(n/8)) + O(n) = 8T(n/8) + O(3n)
\= nT(1) + O(nlogn) = O(n) + O(nlogn) = O(nlogn)

time O(nlogn)
space O(1)
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while(fast != null && fast.next != null) {

            fast = fast.next.next;

            pre = slow;
            slow = slow.next;

        }

        TreeNode root = new TreeNode(slow.val);
        pre.next = null;

        root.left = sortedListToBST(head);
        root.right= sortedListToBST(slow.next);

        return root;

    }
}

/*
  1,2,3,4,5
  | | |
  |   |   |   fast.next == null

  1,2,3,4
  | | |
  |   |   |   fast == null

  1
  |
  |

  1,2
  | |
  |   |
*/
