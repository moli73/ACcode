public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {  1.如果某list为null，则无交点
            return null;
        }

        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {       case : [1], [1] 2.一开始就相交，两个list相同
            p1 = p1.next;
            p2 = p2.next;
            if(p1 == p2) {  先判断是否相同，再跳点。有可能同时到达null case: [1,2], [3]
                break;       两个list没有交点
            }
            if(p1 == null) {
                p1 = headB;
            }
            if(p2 == null) {
                p2 = headA;
            }
        }

        return p1;
    }
}
