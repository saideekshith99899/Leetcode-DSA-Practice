class Solution {
    public int countGoodRotations(int[] nums) {
        int result =0;
        int half = nums.length / 2;
        long total_sum = 0;
        for(int i=0; i<nums.length;i++) {
            total_sum += nums[i];
        }

        long first_half = 0;
        for(int j = 0; j<half; j++) {
            first_half+= nums[j];
        }
        long second_half = 0;
        for(int rot = 0; rot <nums.length; rot++) {
            second_half = total_sum - first_half;
            if(first_half > second_half) {
                result++;
            }

            first_half = first_half - nums[rot];// rem 0 - index
            first_half += nums[(rot+half) % nums.length]; // add -4
        }
        return result;
    }
}
