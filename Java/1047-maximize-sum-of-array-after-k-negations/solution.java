class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {

        int sum = 0;
        Arrays.sort(nums);

        // Flip negative values first
        for(int i = 0; i < nums.length && k > 0; i++) {

            if(nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
        }

        // If remaining k is odd, flip smallest absolute value
        if(k % 2 == 1) {

            int min = Integer.MAX_VALUE;

            for(int num : nums) {
                min = Math.min(Math.abs(num), min);
            }

            for(int i = 0; i < nums.length; i++) {
                if(Math.abs(nums[i]) == min) {
                    nums[i] = -nums[i];
                    break;
                }
            }
        }

        // Calculate final sum
        for(int num : nums) {
            sum += num;
        }

        return sum;
    }
}
