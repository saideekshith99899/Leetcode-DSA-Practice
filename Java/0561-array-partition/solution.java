class Solution {
    public int arrayPairSum(int[] nums) {
       int sum = 0;
       int min = Integer.MAX_VALUE;
       Arrays.sort(nums);
       for(int i=0 ; i<nums.length; i= i+2) {
        int first = nums[i];
        int second = nums[i+1];
        min = Math.min(first,second);
        sum = sum + min;
       }
       return sum;
    }
}
