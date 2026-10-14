class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int even_count = 0;
        for(int i=0 ; i<nums.length; i++) {
            if(nums[i] % 2 == 0) {
                even_count++;
            }
        }

        if(even_count >= 2) return true;
        return false;
    }
}
