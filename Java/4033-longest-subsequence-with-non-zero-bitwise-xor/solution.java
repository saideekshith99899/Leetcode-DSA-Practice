class Solution {
    public int longestSubsequence(int[] nums) {
        int xormax = 0;
        int ormax = 0;
        for(int i=0; i<nums.length; i++) {
            xormax = xormax ^ nums[i];
            ormax = ormax | nums[i];
        }

        if(xormax != 0) {
            return nums.length;
        }

        return (ormax != 0) ? nums.length - 1 : 0;
    }
}
