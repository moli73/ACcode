public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dump = new ListNode(0);
        dump.next = head;
        ListNode start = head;
        ListNode end = head;
        ListNode pre = dump;
        int count = 0;
        while(start != null){
            end = start;
            while(end != null && count != k){
                count++;
                end = end.next;
            }
            if(count != k) return dump.next;
            else count = 0;
            ListNode tail = start;
            while(start != end){//do reverse
                ListNode temp = start.next;//keep the next node
                start.next = pre.next;
                pre.next = start;//insert the node to front
                start = temp;
            }
            pre = tail;
            tail.next = end;
            start = end;
        }
        return dump.next;
    }

}
