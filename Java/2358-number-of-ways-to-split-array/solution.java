class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for(int i= 1; i< nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        long totalsum = prefix[nums.length - 1];
        for(int i=0 ; i<prefix.length - 1; i++) {
            long leftsum = prefix[i];
            long rightsum = totalsum - leftsum;
            if(leftsum >= rightsum) {
                count++;
            }
        }
      return count;  
    }
}
