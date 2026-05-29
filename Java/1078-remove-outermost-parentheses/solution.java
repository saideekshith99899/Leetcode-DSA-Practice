class Solution {
    public String removeOuterParentheses(String s) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
        if(ch == '(') {
            count++;
            if(count == 1) {
                continue;
            }
            else{
                sb.append(ch);
            }
        }
        else{     // ch == ')'
            if(count!=1){
                sb.append(ch);
            }
            count--;
        }          
        }
        return sb.toString();
    }
}
