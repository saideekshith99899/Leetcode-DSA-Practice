class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i < words2.length; i++) {
            char[] ch = words2[i].toCharArray();

            HashMap<Character, Integer> temp = new HashMap<>();
            for(int j= 0; j < ch.length; j++) {

                    if(temp.containsKey(ch[j])){
                        temp.put(ch[j], temp.get(ch[j])+1);
                    }
                    else{
                        temp.put(ch[j],1);
                    }
            }
// merging whole words2 set 
            for(char c: temp.keySet()){
                if(map.containsKey(c)){
                    map.put(c,Math.max(map.get(c), temp.get(c)));
                }
                else{
                    map.put(c, temp.get(c));
                }
            }
        }
            for(int i = 0; i< words1.length; i++) {
                char[] ch = words1[i].toCharArray();
                HashMap<Character, Integer> temp2 = new HashMap<>();    

                for(int j=0; j< ch.length; j++) {
                    if(temp2.containsKey(ch[j])){
                        temp2.put(ch[j], temp2.get(ch[j])+1);
                    }
                    else{
                        temp2.put(ch[j],1);
                    }
                }
                int satisfied = 0;
                for(char c: map.keySet()){
                    if(temp2.containsKey(c) && temp2.get(c) >= map.get(c)){
                        satisfied++;
                    }
                }     
                if(satisfied == map.size()) {
                    result.add(words1[i]);
                }           
            }
            return result;        
    }
}
