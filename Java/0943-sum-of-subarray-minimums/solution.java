class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        long sum = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

    // fill left[] - distance to previous smaller or equal element
        for(int i=0; i< n; i++){
        while(!stack.empty() && arr[stack.peek()] >= arr[i]) {
            stack.pop();
        }
        left[i] = stack.empty() ? i+1 : i - stack.peek(); 
        stack.push(i);
        }

        stack.clear();

        // fill right[] - - distance to next smaller element

        for(int i = n - 1; i>=0; i--) {
            while(!stack.empty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        for(int i=0; i<n;i++) {
            sum = (sum + (long) arr[i] * left[i] * right[i]) % mod;
        }
        return (int) sum;
    }
}
