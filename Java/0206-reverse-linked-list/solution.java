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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        int[] result = new int[count];
        temp = head;
        for(int i= 0; i< count; i++) {
            result[i] = temp.val;  
            temp = temp.next;
        }

        ListNode dummy = new ListNode();
        ListNode current = dummy;

        for(int i= count -1; i>=0; i--) {
        current.next= new ListNode(result[i]);
        current = current.next;
        }

        return dummy.next;

    }
}
