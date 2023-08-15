class Solution {
    public String removeOuterParentheses(String s) {

        int balance =0;
        int start =0;
        StringBuilder  result = new StringBuilder();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            if(c== '('){
                balance++;
            }
            else
            {
                balance--;
            }

            if(balance==0){
                result.append(s.substring(start +1 ,i));
                start=1+i;
            }

        }
        return result.toString();
        
    }
}
