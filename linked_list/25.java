class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		ListNode newHead = dummy;

        ListNode cur = head;

        while(cur != null) {
            ListNode start = cur;

            for(int i = 0; i < k; i++) {
                if(cur == null) {
                    tail.next = start;
                    return dummy.next;
                }
                cur = cur.next;
            }

            while(start != cur) {
                ListNode next = start.next;

                if(newHead == tail) {
                    tail = start;
                }

                start.next = newHead.next;
                newHead.next = start;

                start = next;
            }

            newHead = tail;
        }

        return dummy.next;

    }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode front = dummy;
        ListNode back = dummy;
        ListNode cur = head;
        while(cur != null) {
            ListNode move = cur;
            front = back;
            for(int i = 0; i < k; i++) {
                if(cur == null) {
                    front.next = move;
                    return dummy.next;//不够k个node，要把后面的剩下节点连起来
                }
                cur = cur.next;
            }
            for(int i = 0; i < k; i++) {
                ListNode next = move.next;
                move.next = front.next;
                front.next = move;
                move = next;
                if(front == back) {
                    back = front.next;
                }
            }
        }
        return dummy.next;
    }
}
