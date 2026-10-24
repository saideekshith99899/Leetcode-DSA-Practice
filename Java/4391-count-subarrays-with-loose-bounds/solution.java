class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int left = 0;
        long count = 0;
        int n = nums.length;
        for(int right = 0 ;right < n; right++) {
            if(nums[right] < minK || nums[right] > maxK){
                left= right+1;
            }
            else{
                count += right - left + 1;
            }
        }
        return count;
    }
}
