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
    public ListNode insertionSortList(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }

        int n = count;
        int[] nums = new int[n];
        temp = head;
        for(int i=0; i<n ; i++) {
            nums[i] = temp.val;
            temp = temp.next;
        }

        Arrays.sort(nums);

        ListNode dummy  = new ListNode();
        ListNode current = dummy;
        for(int i = 0; i< n; i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }

        return dummy.next;
    }
}
