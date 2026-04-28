class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< s.length(); i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }
            else{
                map.put(ch,1);           // After building freq map: {a:1, b:1, c:1, d:1}
            }
        }

        for(int i = 0 ; i< order.length(); i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                for(int j = 0; j<map.get(ch);j++){
                    sb.append(ch);       
                }
            }
            map.remove(ch);         //ch = 'a' → append 'a' → remove 'a' → map: {d:1} -(last)
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(map.containsKey(ch)){
                sb.append(ch);
            }
        }
        return sb.toString();        
    }
}
