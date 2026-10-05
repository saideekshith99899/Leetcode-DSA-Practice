class Solution {
    public int scoreOfParentheses(String s) {
       Stack<Integer> stack = new Stack<>();
       stack.push(0);
       for(int i =0; i< s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == '(') {
            stack.push(0);

        }
        else{
            // char = ' )'
    
            int current = stack.pop();
            int value = (current == 0) ? 1 : current * 2;
            stack.push(stack.pop() + value);
        }
       }

       return stack.pop();
    }
}
