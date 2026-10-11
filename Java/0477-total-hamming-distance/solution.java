class Solution {
    public int totalHammingDistance(int[] nums) {
        int distance = 0;
        for(int i = 0; i< nums.length; i++) {
            for(int j = i+1 ; j<nums.length; j++) {
                distance +=  hammingDistance(nums,nums[i],nums[j]);
            }
        }
        return distance;
    }

    public int hammingDistance(int[] nums, int x, int y) {
        int ans = x ^ y;
        int count = Integer.bitCount(ans);
        return count;
    }
}
