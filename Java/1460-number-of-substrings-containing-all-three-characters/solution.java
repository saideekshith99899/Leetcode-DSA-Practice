class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int count = 0;
        int left = 0;
        int n  = s.length();

        for(int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            if(map.containsKey(ch)) {

                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }

            while(map.containsKey('a') && map.containsKey('b')
                          && map.containsKey('c')) {

                   count = count + (n - right); 
        // count all the substrings at once abc,abca,abcab,abcabc  

                    // shrink logic
                char leftchar = s.charAt(left);
                map.put(leftchar, map.get(leftchar) - 1);

                if(map.get(leftchar) == 0){
                    map.remove(leftchar);
                }        
                left++; 
            }                
        }
        return count;        
    }
}
