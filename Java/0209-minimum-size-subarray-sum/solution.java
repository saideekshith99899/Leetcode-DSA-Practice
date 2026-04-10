class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minresult = Integer.MAX_VALUE;

        for(int right = 0; right < nums.length; right++) {

            sum = sum + nums[right];

            while(sum >= target) {
                // window shrinks 

                minresult = Math.min(minresult, right-left+1);
                sum = sum - nums[left];
                left++;
            }

        }
        return minresult == Integer.MAX_VALUE ? 0 : minresult;
        
    }
}
