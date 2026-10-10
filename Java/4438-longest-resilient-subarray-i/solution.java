class Solution {
    public int resilientSubarray(int[] nums, int k) {
       int n = nums.length;
        int maxLength = 1;
        int start = 0;
        for(int i= 1; i<=n; i++) {
            if(i < n && nums[i] % k == nums[start] % k) {
                continue;
            }
            int length = i - start;
            int rem = nums[start] % k;
            int period = k / gcd(rem, k);
            int valid = 1 + ((length-1)/period) * period;
            maxLength = Math.max(maxLength, valid);
            start = i;
        }
        return maxLength;
    }
    public int gcd(int rem, int k){
        while(k !=0) {
            int temp = rem % k;
            rem = k;
            k = temp;
        }
        return rem;
    }
}

