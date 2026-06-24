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
    public ListNode sortList(ListNode head) {
        // base case(split until u get 1 ele)
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while(fast != null  && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast= fast.next.next;         
        }

        prev.next = null;   // divide two list (breaks)

        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        while(list1 !=null && list2 !=null ) {
            if(list1.val < list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            }
            else{
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        while(list1!= null) {
            current.next = list1;
            current= current.next;
            list1 = list1.next;
        }

        while(list2!=null){
            current.next = list2;
            current = current.next;
            list2 = list2.next;
        }
       return dummy.next;
    }
}
