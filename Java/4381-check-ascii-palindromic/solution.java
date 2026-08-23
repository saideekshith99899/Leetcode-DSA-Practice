class Solution {
    
    public boolean isPalindromic(String s) {    
        String binary = "";
        for(int i=0;i<s.length();i++){
            int ascii = (int)s.charAt(i);
            binary = binary + String.format("%8s",Integer.toBinaryString(ascii)).replace(' ','0');
        }
        int left = 0;
        int right = binary.length()-1;
        boolean palindrome = true;
        while(left < right){
            if(binary.charAt(left) != binary.charAt(right)){
                
                palindrome = false;
                break;
            }
            left++;
            right--;
        }
        return palindrome;
    }
}
