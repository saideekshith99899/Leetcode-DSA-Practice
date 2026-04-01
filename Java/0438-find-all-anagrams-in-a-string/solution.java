class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if(p.length() > s.length()) return result;

        HashMap<Character, Integer> pmap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // p str count 
       for(int i=0; i<p.length();i++){
        char ch = p.charAt(i);
        if(pmap.containsKey(ch)){
            pmap.put(ch, pmap.get(ch)+1);
        }
        else{
            pmap.put(ch,1);
        }
    }

    int left = 0;
    int k = p.length();       // sliding window apply on str s 

    for(int right = 0; right < s.length(); right++) {
        char ch = s.charAt(right);

        if(window.containsKey(ch)){
            window.put(ch, window.get(ch)+1);
        }
        else{
            window.put(ch,1);
        }

        if(right - left +1 == k){

            if(window.equals(pmap)) {
                result.add(left);
            }

            char leftchar = s.charAt(left);
            window.put(leftchar, window.get(leftchar) - 1);

            if(window.get(leftchar) == 0){
                window.remove(leftchar);
            } 

            left++;
        }       
    }

    return result;
        
    }
}
