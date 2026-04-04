class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxlen = 0;
        
        for(int right=0; right<s.length(); right++) {

            char ch = s.charAt(right);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)+1);                
            }
            else{
                map.put(ch, 1);
            }
            
            while(map.get(ch) > 1) {
                char leftchar = s.charAt(left);
                map.put(leftchar, map.get(leftchar) - 1);
                left++;
            }

            maxlen = Math.max(maxlen, right-left+1);
        }

        return maxlen;        
    }
}
