class Solution {
    public int maxScore(String s) {
        
        int total1 = 0;
        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '1') {
                total1++;
            }
        }
        int left0 = 0,result = 0, left1=0;
        int right1;

        for(int i = 0; i< s.length() - 1; i++) {
            char ch = s.charAt(i); 
            if(ch == '0') {
                left0++;
            }
            else{
                left1++;
            }

            right1 = total1 - left1;
            result = Math.max(result, left0 + right1);

        }
        return result;
    }
}
