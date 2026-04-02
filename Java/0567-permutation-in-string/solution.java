class Solution {
    public boolean checkInclusion(String s1, String s2) {

        HashMap<Character,Integer> s1map = new HashMap<>(); 
        HashMap<Character, Integer> s2map = new HashMap<>();

        if(s1.length() > s2.length()) return false;

        // s1 map count hashmap

        for(int i=0; i<s1.length(); i++) {

            char ch = s1.charAt(i);

            if(s1map.containsKey(ch)){
                s1map.put(ch, s1map.get(ch) + 1);
            }
            else{
                s1map.put(ch,1);
            }
        }


        // window concept start for s2

        int left = 0;
        int k = s1.length();
        for(int right = 0; right < s2.length(); right++) {

            char ch = s2.charAt(right);

            //count s2 in hashmap

            if(s2map.containsKey(ch)) {
                s2map.put(ch,s2map.get(ch)+1);
            }
            else{
                s2map.put(ch,1);
            }

        // sliding window size 

        if(right - left + 1 == k){

            if(s2map.equals(s1map)) return true;

            char leftchar = s2.charAt(left);

            s2map.put(leftchar, s2map.get(leftchar) - 1);

            if(s2map.get(leftchar) == 0){
                s2map.remove(leftchar);
            }
            left++;
        }

    }
        return false;
        
    }
}
