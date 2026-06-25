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
    public void reorderList(ListNode head) {
        ListNode list1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode list2 = null;
        // split the list 
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        list2 = slow.next;
        slow.next = null;
        // reverse second list from next poiinter is start of second list      
        ListNode prev = null;
        ListNode current = list2;
        ListNode next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;            
            prev = current;
            current = next;
        }
        list2 = prev;      
        // merge the list 
        while(list1 != null && list2 != null) {
            ListNode next1 = list1.next;
            ListNode next2 = list2.next;    
            list1.next = list2;
            list2.next = next1;     
            list1 = next1;
            list2 = next2;
        }
        
    }
}
