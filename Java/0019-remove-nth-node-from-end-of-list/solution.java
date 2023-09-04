/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy=head;
        int count=1;
        while(dummy!=null){
            dummy=dummy.next;
            count++;
        }




        int posi = count - n;
        if(posi==1){
          return head.next;
        }
        ListNode temp=null;
        dummy=head;
        for(int i=1;i<posi;i++){
            temp=dummy;
            dummy=dummy.next;

        }

        temp.next = dummy.next;
        return head;
        
    }
}
