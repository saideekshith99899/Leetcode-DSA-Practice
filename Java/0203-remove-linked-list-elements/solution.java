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


public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Handle empty list case
        if (head == null) {
            return null;
        }

        // Handle the case where the first nodes have the target value
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }

        return head;
    }
}


