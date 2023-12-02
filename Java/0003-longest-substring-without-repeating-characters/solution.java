class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int count = 0;
        Set<Character> hash = new HashSet<>();
        int left =0;

        for(int right =0;right<n;right++){
            if(!hash.contains(s.charAt(right))){
                hash.add(s.charAt(right));
                count = Math.max(count, right-left+1);
            }

            else
            {
                while(hash.contains(s.charAt(right))){

                    hash.remove(s.charAt(left));
                    left++;
                }

                hash.add(s.charAt(right));
            }
        }
        
        return count;
    }
}
