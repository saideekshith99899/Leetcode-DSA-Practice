class Solution {
    public String firstPalindrome(String[] words) {
        for(int i=0; i< words.length ; i++) {
            String ch  = words[i];
            int left = 0;
            int right = ch.length() - 1;
            while(left < right) {
                
                if(ch.charAt(left) == ch.charAt(right)) {
                    left++;
                    right--;
                }
                 else { 
                break;
            } 
        }

            if(left >= right) return words[i];   // palindrome
              
        }

        return "";
        
    }
}
