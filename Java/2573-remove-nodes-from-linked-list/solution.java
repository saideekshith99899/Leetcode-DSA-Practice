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
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
       // convert list -> array -> NGE logic 
        while(head!=null){
            nums.add(head.val);
            head= head.next;
        }
        // NGE logic
        for(int i=0 ;i<nums.size(); i++) {
            result.add(0); // set result arraylist to all 0s.
            while(!stack.empty() && nums.get(stack.peek()) < nums.get(i)){
                int index = stack.pop();
                result.set(index,nums.get(i));
            }
            stack.push(i);
        }
 // created arraylist and added 13 and 8 from nums array
    for(int i=0; i<result.size(); i++) {

        if(result.get(i) == 0) {
            ans.add(nums.get(i));
        }
    }
// in que mentioned return list -> ans is arraylist -> convert to linkedlist

ListNode dummy = new ListNode(0);
ListNode current = dummy;
for(int val : ans){
    current.next = new ListNode(val);
    current = current.next;
}       
return dummy.next;
    }
}
