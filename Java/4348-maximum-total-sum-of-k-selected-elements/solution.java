class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        long sum = 0;
        Arrays.sort(nums);
        int n = nums.length - 1;
        for(int i = n; i > n-k; i--) {
            if(mul > 0){
                sum = sum + (long) nums[i] * mul;
                mul--;
            }
            else{
                sum = sum + nums[i];
            }
        }
        return sum;
    }
}
