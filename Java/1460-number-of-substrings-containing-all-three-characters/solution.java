class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int result=0;
        int[] count= new int[3];



        for(int right =0; right < s.length(); right++){

        char currentchar  =  s.charAt(right);

        count[currentchar - 'a']++;

        while(count[0] > 0 && count[1]> 0 && count[2] > 0 ){

            char leftchar = s.charAt(left);
            count[leftchar - 'a']--;
            left++;
        } 

        result = result+ left;

        }
        
        return result; 
    }
}
