class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];
        //Arrays.fill(result,-1);
        for(int i=0; i<nums.length; i++) {
             result[i] = -1;
        }
        int n = nums.length;
        for(int i=0; i< 2 *nums.length; i++) { // need ciruclar loop run 2*n
            while(!stack.empty() && nums[stack.peek()] < nums[i % n]) {
                int index = stack.pop();
                result[index] = nums[i % n];
            }
            if(i < n){
            stack.push(i % n);
            }
        }
        return result;
    }
}
