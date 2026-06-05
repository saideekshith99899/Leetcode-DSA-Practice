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
    public int[] nextLargerNodes(ListNode head) {
        //covert to array
        // write next greater ele logic same question
        Stack<Integer> stack = new Stack<>();     
        ArrayList<Integer> nums = new ArrayList<>();
        
        while(head!= null){
            nums.add(head.val);
            head= head.next;
        }

        int[] result = new int[nums.size()];
        for(int i=0; i<nums.size(); i++) {
            while(!stack.empty() && nums.get(stack.peek())  < nums.get(i) ) {
                int index = stack.pop();
                result[index] = nums.get(i);                
            }
            stack.push(i); // push index
        }
        return result;
    }
}
