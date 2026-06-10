class Solution {
    public int totalSteps(int[] nums) {
        // element , count
        Stack<int[]> stack = new Stack<>();
        int ans = 0;
        for(int i= nums.length - 1; i>=0; i--) {
            int count = 0;
            while(!stack.empty() && stack.peek()[0] < nums[i]) {
                count = Math.max(count+1, stack.peek()[1]);
                stack.pop();
            }
            ans = Math.max(ans, count);
            stack.push(new int[] {nums[i], count});
        }

        return ans;
    }
}
