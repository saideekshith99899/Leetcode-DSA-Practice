class Solution {
    public int maxVowels(String s, int k) {

        int count = 0;
        int left = 0;
        int maxcount = 0;

       for(int right = 0; right < s.length() ; right++) {
        char ch =  s.charAt(right);
           if(ch == 'a' || ch == 'e' || ch == 'i' || ch=='o' || ch == 'u')
        {
            count++;
        }

        if(right - left + 1 == k) {
             maxcount = Math.max(maxcount, count);
             char chl = s.charAt(left);

            if(chl == 'a' || chl == 'e' || chl == 'i' || chl== 'o' || chl =='u'){
               count--;                    
             }
                left++;
        }
    }
        return maxcount;        
    }
}
