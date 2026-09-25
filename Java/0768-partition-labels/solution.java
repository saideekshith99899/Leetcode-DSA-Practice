class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] storeLastIndex = new int[26];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            storeLastIndex[ch - 'a'] = i;
        }
        int start = 0;
        int end = 0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, storeLastIndex[ch-'a']);
            if(i == end) {
                result.add(i-start+1);
                start = i+1;
            }
            
        }
        return result;
    }
}
