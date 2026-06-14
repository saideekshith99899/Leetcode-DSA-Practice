class Solution {
    public int sumSubarrayMins(int[] nums) {
       long sum = 0;
       int n = nums.length;
       int mod = 1000000007;
       Stack<Integer> stack = new Stack<>();
       int[] left = new int[n];  // left = i - pse(stack.peek)
       int[] right = new int[n]; // right = nse - i

        // nse 
       for(int i= 0 ; i< n; i++) {
            while(!stack.empty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }
            left[i] = stack.empty() ? i+1 : i-stack.peek();
            stack.push(i);       
       }

        stack.clear();
       // pse

       for(int i=n-1; i>=0; i--) {
        while(!stack.empty() && nums[stack.peek()] > nums[i]) {
            stack.pop();
        }
        right[i] = stack.empty() ? n-i : stack.peek() - i;
        stack.push(i);        
       }

       for(int i=0; i< n; i++) {
        sum = (sum + ((long) nums[i] * left[i] * right[i]) % mod) % mod;
       }

       return (int)sum;

    }
}
