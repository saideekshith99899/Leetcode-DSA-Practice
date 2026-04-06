class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int maxfreq = 0;
        int left = 0;
        int maxlen = 0;

        for(int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // cout chars in hashmap
            if(map.containsKey(ch)) {

                map.put(ch, map.get(ch)+1);

            }
            else{
                map.put(ch,1);
            }


            // max freq find

            maxfreq = Math.max(maxfreq, map.get(ch));

            // sliding window apply

            while((right - left + 1) - maxfreq > k){
            
            char leftchar = s.charAt(left);
            map.put(leftchar , map.get(leftchar) - 1);
            left++;


            }
            maxlen = Math.max(maxlen, right-left+1);
        }

        return maxlen;

        
    }
}
