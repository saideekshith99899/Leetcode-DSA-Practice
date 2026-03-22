class Solution {
    public String longestPalindrome(String s) {
        int start = 0 , end = 0;

        for(int i = 0 ; i< s.length(); i++) {

            int length1 = expand(s,i,i);   //  odd len palindrome 
                          // center is exactly single char thats y only 'i'
            int length2 = expand(s,i,i+1);  // even len palindrome
             // center is b/w two characters so i, i+1;

            int maxlen = Math.max(length1,length2);

            if(maxlen > end - start) {

                start = i - (maxlen - 1) / 2;
                end = i + maxlen / 2;
            }
        }

        return s.substring(start,end+1);


        }


    public int expand(String s,int left,int right){

        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right))                      
         {
            left--;
            right++;
         }

        return right-left-1;                 

        }
}

