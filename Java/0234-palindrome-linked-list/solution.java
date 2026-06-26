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
    public boolean isPalindrome(ListNode head) {
    int count  = 0;
    ListNode temp = head;
    while(temp != null) {
        count++;
        temp = temp.next;
    }
    int n = count;
    int[] nums = new int[n];
    temp = head;
    for(int i=0; i<n; i++) {
        nums[i] = temp.val;
        temp = temp.next;
    }
    int j = n - 1;
    for(int i= 0 ;i<n; i++) {
        if(nums[i] != nums[j]){
            return false;
        }
        j--;
    } 
    return true;
    }
}
