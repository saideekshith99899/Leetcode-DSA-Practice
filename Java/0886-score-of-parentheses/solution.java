class Solution {
    public int scoreOfParentheses(String s) {
       Stack<Integer> stack = new Stack<>();

       stack.push(0); // push 0 because if stack empty gives error at line 15
       for(int i=0 ; i<s.length(); i++) {
        char ch = s.charAt(i);
     
            if(ch == '(') {
                stack.push(0);
            }
            else{                //  (ch == ')')
                int curr = stack.pop();
                int val = (curr == 0)? 1 : curr*2;
                stack.push(stack.pop() + val);

            }
        }
       return stack.pop();
    }
}
