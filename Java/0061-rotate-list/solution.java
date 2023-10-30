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

          if (head == null || k == 0) {
            return head;
        }

      
        int length = 1;
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

    
        k = k % length;

        if (k == 0) {
            return head;
        }

        
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;

        return newHead;
    
        
    }
}
