class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<Long,Integer> map = new HashMap<>();
        int equal = 0;
        int result = 0;
        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                equal++;
            }
            else{
                int left = Math.min(nums[i],nums[i+1]);
                int right = Math.max(nums[i],nums[i+1]);
                long val = ((long)left << 32) | (right & 0xffffffffL);
                map.put(val, map.getOrDefault(val,0)+1);
                result = Math.max(result,map.get(val));
            }
        }
        return equal + result;
    }
}
