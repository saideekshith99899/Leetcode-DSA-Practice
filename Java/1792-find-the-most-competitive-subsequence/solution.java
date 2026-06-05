class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int originalk = k;
        for(int i = 0; i < nums.length; i++) {
            while(!stack.empty() && stack.size() + (nums.length - i) > originalk) {
                if(stack.peek() > nums[i]){
                    stack.pop();
                   
                }
                else{
                    break;
                }
            }
            if(stack.size() < originalk) {
            stack.push(nums[i]);
            }
        }
        int[] result = new int[stack.size()];
        for(int i = result.length - 1 ; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
