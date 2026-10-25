class Solution {
    public long maximizeSum(int[] nums, int k) {
        long sum=0;
        int  n = nums.length;
        Arrays.sort(nums);
        int[] g = new int[n];
        for(int i=0; i<n; i++){
            char[] digit = String.valueOf(nums[i]).toCharArray();
            Arrays.sort(digit);
            int max_value = 0;
            for(int j=digit.length-1; j>=0; j--) {
                max_value = max_value * 10 + (digit[j]-'0');
            }
            g[i]=max_value-nums[i];
            sum = sum + nums[i];
        }
        Arrays.sort(g);
        for(int i=n-1; i>=0 &&  k>0; i--,k--){
            sum = sum + g[i];
        }
        return sum;
    }        
}
