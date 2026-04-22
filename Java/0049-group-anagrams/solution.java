class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
     
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String word = strs[i];   

            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);   

            // string sort not possible 
            // u converted into chararry, sorted and converted again back string

            if(map.containsKey(key)) {
                map.get(key).add(word);

            }
            else{
                map.put(key, new ArrayList<>());
                map.get(key).add(word);
                // if map not contains key, u need to create one arraylist
                // and add the words not key see prob statement 
            } 
        }           

    return new ArrayList<>(map.values());
        
    }
}
