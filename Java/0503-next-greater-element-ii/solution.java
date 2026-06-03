class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
       Stack<Integer> stack = new Stack<>();
       int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            result[i] = -1;
        }
        // Arrays.fill(result,-1);
        for(int i=0; i<2*nums.length; i++) {
        while(!stack.empty() && nums[stack.peek()] < nums[i%n]) {
                int index = stack.pop();
                result[index] = nums[i%n];
            }
            stack.push(i%n);
        }
        return result;
    }
}
