class Solution {
    public int peakValleyDifference(int[] nums) {
        int sum_peak = 0;
        int sum_valley = 0;
        int n = nums.length;
        for(int i=1; i<n-1; i++){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) {
                sum_peak += nums[i];
            }
        }
        for(int i=1; i<n-1; i++) {
            if(nums[i] < nums[i-1] && nums[i] < nums[i+1]) {
                sum_valley += nums[i];
            }
        }
        return sum_peak - sum_valley;
    }
}
