class Solution {
    public int minOperations(int[] nums, int k) {
        int xor = 0;
        for(int i = 0 ; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int result = xor ^ k;
        int count = 0;
        while(result > 0) {
            if((result & 1) == 1) { // right most bit 1 or not 
                count++;
            }
            result = result >> 1;
        }
        return count;
    }
}
