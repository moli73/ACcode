Tree:
117. Populating Next Right Pointers in Each Node II
本质是利用dummy node做一个node append，只不过每次append前，check一下要append的node是否存在
同时，每层的起点不一定是cur.left了，应该是dummy.next
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;

        while(cur != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);//用于指向下一行的开头
            TreeLinkNode pre = dummy;

            while(cur != null) {//不需要检查下一层是否为null，连接方式跟116已经不相同了

                if(cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }

                if(cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }

                cur = cur.next;
            }
            cur = dummy.next;
        }
    }
}

116. Populating Next Right Pointers in Each Node
//iterative: constant space complexity
public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode cur = root;

        while(cur != null) {
            TreeLinkNode next = cur.left;//下一层起点

            while(next != null && cur != null) {//是否有下一层

                cur.left.next = cur.right;

                if(cur.next != null) {//本层是否到最后了。

                    cur.right.next = cur.next.left;

                }

                cur = cur.next;
            }

            cur = next;
        }
    }
}
//recursive
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;

        if(root.left != null) {
            root.left.next = root.right;

            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }
}

follow up:将每行最后一个node next连接到下一行开头node
public void populateNextRightPointer(TreeLinkNode root) {
	TreeLinkNode cur = root;
	while(cur != null) {
		TreeLinkNode next = cur.left;
		while(next != null && cur != null) {
			cur.left.next = cur.right;
			if(cur.next != null) {
				cur.right.next = cur.next.left;
			} else {
				break;//上一行最后一个node，退出loop
			}
			cur = cur.next;
		}
		cur.next = next;//cur将cur.next连接到下一层第一个node或者是null
		cur = cur.next;
	}
}
