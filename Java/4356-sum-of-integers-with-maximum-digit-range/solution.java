class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxrange = 0;
    
        for(int i = 0; i < n;i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int temp = nums[i];
            while(temp != 0) {
            int rem = temp % 10;
            max = Math.max(max,rem);
            min = Math.min(min,rem);
            temp = temp / 10;
            }
            int digitrange = max - min;  

            if(digitrange > maxrange) {
                maxrange = digitrange;
                sum = nums[i];
            }
            else if(digitrange == maxrange) {
                sum = sum  + nums[i];
            }
            
        }
        return sum;
    }
}
