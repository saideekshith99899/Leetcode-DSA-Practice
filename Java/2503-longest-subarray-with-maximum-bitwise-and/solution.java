class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        for(int num : nums) {
            max = Math.max(max,num);
        }
        int subarr = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            if(max == nums[i]) {
                count++;
                subarr = Math.max(subarr, count);
            }
            else{
                count = 0;
            }
        }
        return subarr;
    }
}
