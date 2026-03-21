class Solution {
    public boolean isPalindrome(String s) {
        
        int left = 0;
        int right = s.length() - 1;

        while(left < right) {
            
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            // this while loops are for removing , space all etc. 

            while(left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
            {
                return false;
            }

               left++; 
               right--;
        }
    
    return true;
        
    }
}
