//O(n) time complexity
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dump = new ListNode(0);//1.for the bit before the highest bit
        dump.next = head;
        ListNode non9 = dump;
        ListNode move = head;
        while(move != null){
            if(move.val != 9) non9 = move;//2.find the last not 9 bit
            move = move.next;
        }
        non9.val += 1;
        non9 = non9.next;
        //3.reset the bits after the add one bit
        while(non9 != null){
            non9.val = 0;
            non9 = non9.next;
        }
        //4.check if the highest bit set or not to determine the output
        return dump.val == 1 ? dump : head;
    }
}
