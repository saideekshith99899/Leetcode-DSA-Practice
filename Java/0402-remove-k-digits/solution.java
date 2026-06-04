class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< num.length();i++) {
            int digit = num.charAt(i) - '0';
        while(k > 0 && !stack.empty() && stack.peek() > digit) {
            stack.pop();
            k--;
        }
        stack.push(digit);
      }
    // pop remaining if k > 0
      while(k > 0 && !stack.empty()) {
        stack.pop();
        k--;
      }
      StringBuilder sb = new StringBuilder();
      while(!stack.empty()){
        sb.append(stack.pop());
      }
      sb.reverse();
      //remove leading zeros
      while(sb.length() > 1 && sb.charAt(0) == '0'){
        sb.deleteCharAt(0);
      }
      if(sb.length() == 0) return "0";
      
      return sb.toString();       
    }
}
