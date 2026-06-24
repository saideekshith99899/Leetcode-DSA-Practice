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
    public ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current;
        ListNode next;
        ListNode nextpair;
        if(head == null) return head;
        while(prev!= null && prev.next!=null && prev.next.next != null) {         
            current = prev.next;
            next =current.next;
            nextpair = next.next;

            prev.next = next;
            next.next = current;
            current.next = nextpair;
            prev = current;
           
        }
        return dummy.next;
    }
}
