class Solution {
    public int minAddToMakeValid(String s) {
        int min_add = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else if(ch == ')') {
                if(!stack.isEmpty()){
                    if(stack.peek() == '(') {
                    stack.pop();
                    }
                    else{
                        stack.push(ch);
                    }
                }
                else{
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}
