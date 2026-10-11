class Solution {
    public int missingNumber(int[] nums) {    
        int result = nums.length; // n distinct  
       for(int i=0; i<nums.length; i++) {
        result = result ^ (i ^ nums[i]);
       }
       return result;
    }
}
