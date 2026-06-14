class Solution {
    public long subArrayRanges(int[] nums) {
        //similar to 907 max -min
        return getmax(nums) - getmin(nums);
    }
   Stack<Integer> stack = new Stack<>();

    private long getmin(int[] nums){
        long sum = 0;
        int mod = 1000000007;
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for(int i=0; i< n; i++) {
            while(!stack.empty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            left[i] = stack.empty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();


        for(int i=n-1 ; i>=0 ; i--) {
            while(!stack.empty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? n - i: stack.peek() - i;
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            sum = sum + (long) nums[i]*left[i]* right[i];
        }
        return (long)sum;
    }
    private long getmax(int[] nums) {
        int  n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int mod = 1000000007;
        long sum = 0;
        for(int i = 0; i< n; i++) {
            while(!stack.empty() && nums[stack.peek()] <= nums[i]) {

                stack.pop();
            }
            left[i] = stack.empty() ? i+1 : i - stack.peek();
            stack.push(i);
        }
        stack.clear();

        for(int i= n-1; i>=0; i--) {
            while(!stack.empty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for(int i= 0; i< n; i++) {
            sum = sum + (long) nums[i]*left[i]*right[i];
        }
        return (long) sum;
    }
}
