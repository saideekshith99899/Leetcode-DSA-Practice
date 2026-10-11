class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums) {
            xor ^= num;  // xor of nums
        }
        int bit = xor & -xor; 
        int group1 = 0, group2 = 0;
        for(int num: nums) {
            if((bit & num) == 0){
                group1 ^= num;
            }
            else{
                group2 ^= num;
            }
        }
    return new int[]{group1,group2};
    }
}
