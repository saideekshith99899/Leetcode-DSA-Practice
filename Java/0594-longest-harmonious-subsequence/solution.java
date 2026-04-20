class Solution {
    public int findLHS(int[] nums) {

        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
            for(int num: nums) {
                if(map.containsKey(num)){
                    map.put(num, map.get(num)+1);
                }
                else{
                    map.put(num,1);
                }
            }
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int key= entry.getKey();
            int val = entry.getValue();
                if(map.containsKey(key+1)) {
                    result = Math.max(result, map.get(key) + map.get(key+1));
                }        
            }
        return result;        
    }
}
