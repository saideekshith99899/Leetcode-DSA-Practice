class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;

        for(int i = nums.length - 1; i>=0; i--) {

            while(!stack.empty() && nums[i] > stack.peek()){             
                second = stack.pop();               
                
            }
                 stack.push(nums[i]);
            if(nums[i] < second) return true;
       

        } 
        return false;
    }
}
