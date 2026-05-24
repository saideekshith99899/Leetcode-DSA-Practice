class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();i++) {
            char ch = s.charAt(i);
            if(!stack.empty() && stack.peek() == ch) {
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }
        for(char ch : stack){
            sb.append(ch);
        }
        return sb.toString();
    }
}
