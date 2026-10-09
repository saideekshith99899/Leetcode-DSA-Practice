class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int close = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                if(close % 2 == 1) {
                open++;
                close--;
                }
            close = close + 2;               
            }            
            else{
                close--;
                if(close < 0) {
                    open++;
                    close =  1;
                }
            }
        }
        return open + close;
    }
}
