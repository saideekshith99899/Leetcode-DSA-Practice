class Solution {
    public long maxPairStrength(int[] nums) {
        long max = 0;
        for(int i =0; i<nums.length-1; i++) {
            for(int j =i+1; j<nums.length; j++) {
            long gcd = gcd(nums[i],nums[j]);
            long val = ( 1L * nums[i] * nums[j]) / (gcd * gcd);
            max = Math.max(max,val);               
        }
        }
        return max;
    }
    public int gcd(int a, int b) {
       while(b != 0) {
           int temp = b;
           b = a % b;
           a = temp;
       }
    return a;
    }   
}
