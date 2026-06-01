class Solution {
    public int[] dailyTemperatures(int[] temp) {
        // same pattern next greater element 
        int[] result = new int[temp.length];
        Stack<Integer> stack= new Stack<>();
        for(int i=0; i< temp.length; i++) {
            while(!stack.empty() && temp[stack.peek()] < temp[i]) {
                int index = stack.pop(); 
                result[index] = i - index;  // j - i; bruteforce logic
                // result[index] = current element
            }
            stack.push(i);
        } 
       return result;
    }
}
