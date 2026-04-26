class Solution {
    public boolean closeStrings(String word1, String word2) {

        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i= 0; i< word1.length(); i++) {

            char ch = word1.charAt(i);
            if(map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch)+1);
            }
            else{
                map1.put(ch, 1);
            }
        }
        for(int i =0 ; i<word2.length(); i++) {
            char ch = word2.charAt(i);
            if(map2.containsKey(ch)) {
                map2.put(ch,map2.get(ch) + 1);
            }
            else{
                map2.put(ch,1);
            }
        }
        list1.addAll(map1.values()); // converted in array and did sort
        list2.addAll(map2.values()); // converted in array and did sort

        Collections.sort(list1);          
        Collections.sort(list2);

        return map1.keySet().equals(map2.keySet()) && list1.equals(list2);
                    
            // For word1 = "aabbc":
                //map1 = {a:2, b:2, c:1}
                //map1.keySet() → [a, b, c]
                //map1.values() → [2, 2, 1]       
    }
}
