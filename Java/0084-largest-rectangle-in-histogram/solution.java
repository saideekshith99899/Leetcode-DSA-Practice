class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int width, area = 0, result = - 100;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<n; i++) {
            while(!stack.empty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.empty() ? i+1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1 ; i>=0; i--) {
            while(!stack.empty() && heights[stack.peek()] > heights[i]) {
                stack.pop();
            }
            right[i] = stack.empty() ? n- i: stack.peek() - i;
            stack.push(i);
        }

        for(int i=0; i<n; i++) {
            width =  left[i] + right[i] -1;
            area= heights[i] * width ;
            result = Math.max(area ,result);          
        }
        return result;
    }
}
