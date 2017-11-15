corner case
1.[]
2.[[],[],[1]],入pq前需要检查每个node是否为null

solution2: divide and conquer (merge sort)
time: O(nlogk)    merge two lists O(N)，要进行O(logk)次
space： O(1)      stack space: O(logk)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int left, int right) {
        if(left > right) {
            return null;
        }
        if(left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l1 = partition(lists, left, mid);//只剩两个list的情况被包含了。
        ListNode l2 = partition(lists, mid + 1, right);
        return merge2Lists(l1, l2);
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;//pre其实是个tail指针

        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                //不需要next temp指针的写法
                pre.next = l1;
                pre = pre.next;//pre = l1;

                l1 = l1.next;
                pre.next = null;//将新链表断开，好习惯
            } else {
                pre.next = l2;
                pre = pre.next;//pre = l2;

                l2 = l2.next;
                pre.next = null;
            }
        }

        if(l1 != null) {
            pre.next = l1;
        }
        if(l2 != null) {
            pre.next = l2;
        }

        return dummy.next;
    }
}

优先队列的初始化容量不能是0<<------------
solution1: priority queue 选每个list的代表
time: O(nlogk)
space: O(k)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        Queue<ListNode> pq = new PriorityQueue<ListNode>(10, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        for(int i = 0; i < k; i++) {
            if(lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while(pq.size() > 1) {// 只剩一个node可以直接add
            ListNode cur = pq.poll();

            ListNode next = cur.next;

            cur.next = pre.next;
            pre.next = cur;

            pre = pre.next;

            if(next != null) {
                pq.offer(next);
            }
        }

        if(!pq.isEmpty()) {     //注意判断是否empty
            ListNode cur = pq.poll();
            pre.next = cur;
        }

        return dummy.next;
    }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(11, new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        for(ListNode head : lists) {
            if(head != null) {
                pq.offer(head);
            }
        }

        while(!pq.isEmpty()) {
            ListNode cur = pq.poll();

            if(cur.next != null) {
                pq.offer(cur.next);
            }

            cur.next = tail.next;
            tail.next = cur;

            tail = tail.next;
        }

        return dummy.next;
    }
}
