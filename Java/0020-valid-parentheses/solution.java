class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i< s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.empty()) return false;  //ex: ))) 
                else{
                    char ch = stack.peek();
                    stack.pop();
                    if((ch == '(' && s.charAt(i) == ')') || (ch=='{' && s.charAt(i) == '}') || (ch == '[' && s.charAt(i) == ']')) 
                    {
                        //continue total string 
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(stack.empty()) return true;
        else return false;
    }
}
