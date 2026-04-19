class Solution {
    public int findLucky(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int result = -1;

        for(int i=0; i< nums.length; i++) {
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }    

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();

            if(key == val) {
                result = Math.max(result, val);
            }           
        }   
    return result; 
    }
}
