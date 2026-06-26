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
    public ListNode partition(ListNode head, int x) {
        
     ListNode leftdummy =  new ListNode();
     ListNode rightdummy = new ListNode();
     ListNode left = leftdummy;
     ListNode right = rightdummy;
     ListNode current = head;
     while(current != null) {
        if(current.val < x) {
            left.next = current;
            left = left.next;
            current = current.next;
        }       
        else{
            right.next = current;
            right = right.next;
            current = current.next;
        }
     }    
     left.next = rightdummy.next;
     right.next = null;
     return leftdummy.next;

    }   
}
