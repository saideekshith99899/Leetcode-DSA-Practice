class Solution {
    public int xorOperation(int n, int start) {
        int[] nums = new int[n];
        for(int i=0; i < n; i++) {
            nums[i] = start + 2 * i;
        }
        int result = 0; // 0 ^ b = b (dont take 1)
        for(int i=0; i< nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }
}
