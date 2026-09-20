class Solution {
    public long maxValue(int[] nums) {
        long[] maximum = {0,Long.MIN_VALUE};
        long prefix = 0;
        long minSum = 0;
        for(int i=0; i<nums.length ; i++) {
            if(i % 2 == 0) {
                prefix = prefix + nums[i];
            }
            else{
                prefix = prefix - nums[i];
            }

            int t = (i + 1) % 2;
            if(maximum[t] != Long.MIN_VALUE){
            minSum = Math.min(minSum, prefix - maximum[t]);
            }
            maximum[t] = Math.max(maximum[t], prefix);
        }
        return prefix - 2 * minSum;
    }
}
