//the time complexity is O(n), spcace complexity is also O(n)
//split the greater and euqal number from the origin list to a new list, and merge them
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        ListNode extr = new ListNode(0);
        extr.next = head;
        ListNode temp = head;//similar to give the same name to same memory area in computer, which means we use two variable to refer the same memory area
        ListNode pre = extr;

        ListNode dump = new ListNode(1);
        ListNode tail = dump;

        while(temp != null){
            //if the temp.val greater or equals to x, merge to a new link list
            if(temp.val >= x){
                pre.next = temp.next;//split the temp node from the origin list

                temp.next = tail.next;//insert the tail node to the tail
                tail.next = temp;
                tail = tail.next;//merge temp node to new list's tail

                temp = pre.next;//move to the origin's next node
            }
            else{
                pre = temp;
                temp = temp.next;
            }
        }
        //merge the two link lists
        pre.next = dump.next;
        return extr.next;
    }
}
