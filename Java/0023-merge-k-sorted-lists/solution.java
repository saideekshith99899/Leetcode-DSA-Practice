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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a,b) -> a.val - b.val);
        for(ListNode head : lists){
            if(head != null) {
                pq.add(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(!pq.isEmpty()) {
            ListNode top = pq.poll();
            if(top.next != null){
            pq.add(top.next);
            }
            current.next = top;
            current = current.next;

        }
        return dummy.next;
    }
}
