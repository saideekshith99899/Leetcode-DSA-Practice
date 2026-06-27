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
    public ListNode[] splitListToParts(ListNode head, int k) {
    int count = 0;
    ListNode temp = head;
    while(temp != null){
        count++;
        temp = temp.next;
    }

    ListNode[] result = new ListNode[k];
    int n = count;
    int base = n / k;
    int rem = n % k;

    ListNode current = head;
    ListNode next;
    for(int i=0; i < k; i++) {
        int partition = base +(rem-- > 0? 1:0);
        result[i] = current;
        for(int j=0; j<partition - 1; j++){
            current = current.next;
        }

        if(current != null){
            next = current.next;
            current.next = null;
            current = next;
        }
    }
    return result;
    }
}
