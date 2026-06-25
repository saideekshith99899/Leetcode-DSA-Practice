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
    public ListNode rotateRight(ListNode head, int k) {

     if(head == null || head.next == null) return head;
       
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        k = k % count;

        if(k == 0) return head;
        ListNode end = head;
        for(int i=0; i< count - k - 1; i++) {
            end= end.next;
        }
        ListNode newhead = end.next;
        end.next = null;
        temp = newhead;
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = head;
        return newhead;

    }
}
