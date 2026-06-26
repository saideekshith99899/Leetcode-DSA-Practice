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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode list1 = head;
        ListNode list2;
        ListNode before = null;
    
    // split into two lists
        while(fast != null && fast.next != null) {
            before= slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        before.next = null;
   
    
    // revrse list2

    ListNode prev = null;
    ListNode current = slow;
    ListNode next;

    while(current != null) {
        next = current.next;
        current.next = prev;
        prev = current;
        current = next;
    }   
    list2 = prev;

    // add and find max

    int max = 0;

    while(list1 != null || list2 != null) {
        int sum = 0;
        if(list1 != null) {
            sum = sum + list1.val;
            list1 = list1.next;
        }
        if(list2 != null) {
            sum = sum + list2.val;
            list2 = list2.next;
        }

        max = Math.max(sum, max);
    }
        return max;
    }
}
